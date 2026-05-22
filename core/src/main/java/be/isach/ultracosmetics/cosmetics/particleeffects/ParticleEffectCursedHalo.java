package be.isach.ultracosmetics.cosmetics.particleeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ParticleEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;

public class ParticleEffectCursedHalo extends ParticleEffectHalo {

    public ParticleEffectCursedHalo(UltraPlayer owner, ParticleEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }

    @Override
    public void onUpdate() {
        drawCircle(0.4f, 6, getPlayer().getEyeLocation().add(0, 0.7, 0));
    }
}
