package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;

/**
 * Represents an instance of a cod morph summoned by a player.
 *
 * @author Chris6ix
 * @since 26-10-2022
 */
public class MorphCod extends Morph {
    public MorphCod(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }
}
