package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a allay morph summoned by a player.
 *
 * @author Chris6ix
 * @since 25-10-2022
 */
public class MorphAllay extends MorphFlightAbility {
    public MorphAllay(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_ALLAY_AMBIENT_WITH_ITEM);
    }
}