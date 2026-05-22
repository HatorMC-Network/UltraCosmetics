package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a cow morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphCow extends MorphPlaySound {
    // TODO: Add something better for this morph - having it just "moo" isn't much.
    public MorphCow(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_COW_AMBIENT);
    }
}
