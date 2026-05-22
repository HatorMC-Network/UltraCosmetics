package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a frog morph summoned by a player.
 *
 * @author Chris6ix
 * @since 29-10-2022
 */
public class MorphFrog extends MorphPlaySound {
    public MorphFrog(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_FROG_AMBIENT);
    }
}
