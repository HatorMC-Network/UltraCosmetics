package be.isach.ultracosmetics.cosmetics.particleeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ParticleEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.MathUtils;
import org.bukkit.Location;

public class ParticleEffectHalo extends ParticleEffect {

    public ParticleEffectHalo(UltraPlayer owner, ParticleEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);

        this.useAlternativeEffect = true;
    }

    @Override
    public void onUpdate() {
        drawCircle(0.4f, 20, getPlayer().getEyeLocation().add(0, 0.7, 0));
    }

    public void drawCircle(float radius, int amount, Location location) {
        for (int i = 0; i < amount; i++) {
            double inc = (2 * Math.PI) / amount;
            float angle = (float) (i * inc);
            float x = MathUtils.cos(angle) * radius;
            float z = MathUtils.sin(angle) * radius;
            location.add(x, 0, z);
            display.spawn(location);
            location.subtract(x, 0, z);
        }
    }
}
