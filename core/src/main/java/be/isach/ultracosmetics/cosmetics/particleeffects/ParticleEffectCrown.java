package be.isach.ultracosmetics.cosmetics.particleeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ParticleEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.MathUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ParticleEffectCrown extends ParticleEffect {

    public ParticleEffectCrown(UltraPlayer ultraPlayer, ParticleEffectType type, UltraCosmetics ultraCosmetics) {
        super(ultraPlayer, type, ultraCosmetics);
    }

    @Override
    public void onUpdate() {
        Location base = getPlayer().getEyeLocation().add(0, 0.3, 0);
        Vector vec = new Vector();
        for (int i = 0; i < 360; i += 10) {
            vec.setX(MathUtils.sinDeg(i));
            vec.setZ(MathUtils.cosDeg(i));
            Location newLoc = base.clone().add(vec.multiply(0.3));
            display.spawn(newLoc);
            // if `i` is within one step of being divisible by 60
            if ((i + 5) % 60 <= 20) {
                newLoc.add(0, 0.2, 0);
                display.spawn(newLoc);
                if (i % 60 == 0) {
                    newLoc.add(0, 0.2, 0);
                    display.spawn(newLoc);
                }
            }
        }
    }

}
