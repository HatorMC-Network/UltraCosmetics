package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a endermite morph summoned by a player.
 *
 * @author Chris6ix
 * @since 29-10-2022
 */
public class MorphEndermite extends MorphPlaySound {
    public MorphEndermite(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_ENDERMITE_AMBIENT);
    }
}
