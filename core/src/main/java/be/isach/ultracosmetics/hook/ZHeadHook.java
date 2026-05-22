package be.isach.ultracosmetics.hook;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * Soft-dependency hook for zHead.
 * All zHead interaction is contained here — no other file imports zHead types.
 * Detection uses ServicesManager so this hook is safe to instantiate even when
 * zHead is absent; {@link #isEnabled()} returns {@code false} in that case.
 */
public class ZHeadHook {

    private final Object headManager;
    private final Method createItemStackMethod;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public ZHeadHook(Plugin plugin) {
        Object manager = null;
        Method method = null;
        if (Bukkit.getPluginManager().isPluginEnabled("zHead")) {
            try {
                Class headManagerClass = Class.forName("fr.maxlego08.zhead.api.HeadManager");
                RegisteredServiceProvider rsp = Bukkit.getServicesManager().getRegistration(headManagerClass);
                if (rsp != null) {
                    manager = rsp.getProvider();
                    method = headManagerClass.getMethod("createItemStack", int.class);
                }
            } catch (ClassNotFoundException | NoSuchMethodException | NoClassDefFoundError ignored) {
            }
        }
        this.headManager = manager;
        this.createItemStackMethod = method;
    }

    public boolean isEnabled() {
        return headManager != null && createItemStackMethod != null;
    }

    /**
     * @param headId numeric ID from minecraft-heads.com
     * @return the head ItemStack, or empty if zHead is absent, the ID is unknown, or an error occurs
     */
    public Optional<ItemStack> getItemStack(int headId) {
        if (!isEnabled()) return Optional.empty();
        try {
            return Optional.ofNullable((ItemStack) createItemStackMethod.invoke(headManager, headId));
        } catch (Exception ignored) {
            return Optional.empty();
        }
    }
}
