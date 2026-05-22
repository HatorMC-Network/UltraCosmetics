package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a bat morph summoned by a player.
 *
 * @author iSach
 * @since 08-26-2015
 */
public class MorphBat extends MorphFlightAbility {
    public MorphBat(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_BAT_LOOP);
    }
}
