package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;

/**
 * Represents an instance of a glow squid morph summoned by a player.
 *
 * @author Chris6ix
 * @since 04-11-2022
 */
public class MorphGlowSquid extends MorphPlaySound {
    public MorphGlowSquid(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, XSound.ENTITY_GLOW_SQUID_AMBIENT);
    }
}
