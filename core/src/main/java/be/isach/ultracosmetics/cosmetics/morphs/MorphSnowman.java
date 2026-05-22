package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Represents an instance of a snowman morph summoned by a player.
 *
 * @author iSach
 * @since 11-29-2015
 */
public class MorphSnowman extends MorphLeftClickCooldown {
    public MorphSnowman(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, 0.5);
    }

    @Override
    public void onLeftClick(PlayerInteractEvent event) {
        event.setCancelled(true);
        event.getPlayer().launchProjectile(Snowball.class);
    }
}
