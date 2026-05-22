package be.isach.ultracosmetics.cosmetics.particleeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ParticleEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;

/**
 * Represents an instance of in love particles summoned by a player.
 *
 * @author iSach
 * @since 08-13-2015
 */
public class ParticleEffectInLove extends ParticleEffect {

    public ParticleEffectInLove(UltraPlayer owner, ParticleEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);

        this.useAlternativeEffect = true;
        display.offset(0.5).withCount(getModifiedAmount(2))
                .withLocationCaller(() -> getPlayer().getLocation().add(0, 1, 0));
    }

    @Override
    public void onUpdate() {
        display.spawn();
    }
}
