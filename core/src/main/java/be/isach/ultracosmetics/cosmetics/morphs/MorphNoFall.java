package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.SettingsManager;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

public class MorphNoFall extends Morph {
    private final boolean noFall = SettingsManager.getConfig().getBoolean(getOptionPath("No-Fall-Damage"));

    public MorphNoFall(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (canUseSkill && noFall && event.getEntity() == getPlayer() && getOwner().getCurrentMorph() == this
                && event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            event.setCancelled(true);
        }
    }
}
