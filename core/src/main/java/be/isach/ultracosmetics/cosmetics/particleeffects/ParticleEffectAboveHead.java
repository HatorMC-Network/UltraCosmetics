package be.isach.ultracosmetics.cosmetics.particleeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ParticleEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;

public class ParticleEffectAboveHead extends ParticleEffect {

    public ParticleEffectAboveHead(UltraPlayer owner, ParticleEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
        display.withExtra(1).withLocationCaller(() -> getPlayer().getEyeLocation().add(0, 0.8, 0));
    }

    @Override
    public void onUpdate() {
        display.spawn();
    }
}
