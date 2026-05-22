package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a cave spider morph summoned by a player.
 *
 * @author Chris6ix
 * @since 26-10-2022
 */
public class MorphCaveSpider extends MorphPlaySound {
    public MorphCaveSpider(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_SPIDER_AMBIENT);
    }
}
