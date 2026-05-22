package be.isach.ultracosmetics.hook;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Soft-dependency hook for zHead.
 * All zHead interaction is contained here — no other file imports zHead types.
 * Detection uses ServicesManager so this hook is safe to instantiate even when
 * zHead is absent; {@link #isEnabled()} returns {@code false} in that case.
 */
public class ZHeadHook {

    private final Object headManager;
    private final Method createItemStackMethod;
    private final Logger logger;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ZHeadHook(Plugin plugin) {
        this.logger = plugin.getLogger();
        Object manager = null;
        Method method = null;
        if (Bukkit.getPluginManager().isPluginEnabled("zHead")) {
            try {
                Class headManagerClass = Class.forName("fr.maxlego08.head.api.HeadManager");
                RegisteredServiceProvider rsp = Bukkit.getServicesManager().getRegistration(headManagerClass);
                if (rsp != null) {
                    manager = rsp.getProvider();
                    method = headManagerClass.getMethod("createItemStack", String.class);
                } else {
                    logger.warning("[zHead] ServicesManager has no provider for HeadManager. Is zHead fully loaded?");
                }
            } catch (ClassNotFoundException e) {
                logger.warning("[zHead] HeadManager class not found: " + e.getMessage());
            } catch (NoSuchMethodException e) {
                logger.warning("[zHead] Method 'createItemStack(String)' not found: " + e.getMessage());
            } catch (NoClassDefFoundError e) {
                logger.warning("[zHead] NoClassDefFoundError: " + e.getMessage());
            }
        }
        this.headManager = manager;
        this.createItemStackMethod = method;
        logger.info("[zHead] Hook status: isEnabled=" + isEnabled());
    }

    public boolean isEnabled() {
        return headManager != null && createItemStackMethod != null;
    }

    /**
     * @param headId numeric ID from minecraft-heads.com
     * @return the head ItemStack, or empty if zHead is absent, the ID is unknown, or an error occurs
     */
    public Optional<ItemStack> getItemStack(String headId) {
        if (!isEnabled()) return Optional.empty();
        try {
            ItemStack result = (ItemStack) createItemStackMethod.invoke(headManager, headId);
            if (result == null) {
                logger.warning("[zHead] createItemStack(\"" + headId + "\") returned null — ID not found in zHead database?");
            }
            return Optional.ofNullable(result);
        } catch (Exception e) {
            logger.warning("[zHead] Error invoking createItemStack(\"" + headId + "\"): " + e.getMessage());
            return Optional.empty();
        }
    }
}
