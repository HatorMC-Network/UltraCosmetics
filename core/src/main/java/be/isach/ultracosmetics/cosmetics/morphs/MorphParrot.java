package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a parrot morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphParrot extends MorphFlightAbility {
    public MorphParrot(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_PARROT_FLY);
    }
}
