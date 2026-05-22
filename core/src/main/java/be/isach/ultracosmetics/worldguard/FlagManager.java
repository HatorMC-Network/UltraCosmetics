package be.isach.ultracosmetics.worldguard;

import be.isach.ultracosmetics.cosmetics.Category;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.EnumFlag;
import com.sk89q.worldguard.protection.flags.SetFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import com.sk89q.worldguard.session.Session;
import com.sk89q.worldguard.session.handler.Handler;
import org.bukkit.entity.Player;

import java.util.Set;

public class FlagManager implements IFlagManager {
    protected static final SetFlag<Category> CATEGORY_FLAG = new SetFlag<>("uc-blocked-categories", new EnumFlag<>(null, Category.class));

    @Override
    public void register() {
        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        for (UCFlag flag : UCFlag.values()) {
            registry.register(flag.getFlag());
        }
        registry.register(CATEGORY_FLAG);
    }

    @Override
    public void registerPhase2() {
        WorldGuard.getInstance().getPlatform().getSessionManager().registerHandler(FACTORY, null);
    }

    @Override
    public boolean flagCheck(UCFlag flag, Player bukkitPlayer) {
        LocalPlayer player = WorldGuardPlugin.inst().wrapPlayer(bukkitPlayer);
        RegionContainer rc = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = rc.createQuery();
        return query.testState(player.getLocation(), player, flag.getFlag());
    }

    @Override
    public Set<Category> categoryFlagCheck(Player bukkitPlayer) {
        LocalPlayer player = WorldGuardPlugin.inst().wrapPlayer(bukkitPlayer);
        RegionContainer rc = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = rc.createQuery();
        return query.queryValue(player.getLocation(), player, CATEGORY_FLAG);
    }

    // from WorldGuard documentation:
    // https://worldguard.enginehub.org/en/latest/developer/regions/custom-flags/
    private static final Factory FACTORY = new Factory();

    public static class Factory extends Handler.Factory<CosmeticFlagHandler> {
        @Override
        public CosmeticFlagHandler create(Session session) {
            return new CosmeticFlagHandler(session, UCFlag.COSMETICS.getFlag(), UCFlag.SHOWROOM.getFlag(), CATEGORY_FLAG);
        }
    }
}
