package be.isach.ultracosmetics.cosmetics.particleeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ParticleEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ParticleEffectFootprints extends ParticleEffect {

    public ParticleEffectFootprints(UltraPlayer owner, ParticleEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);

        this.displayIfStanding = false;
    }

    @Override
    public void onUpdate() {
        display.spawn(getSideVector(getPlayer().getLocation(), false));
        display.spawn(getSideVector(getPlayer().getLocation(), true));
    }

    private static Location getSideVector(Location loc, boolean right) {
        double multiplier = right ? -0.15 : 0.15;
        double rads = Math.toRadians(loc.getYaw());
        Vector v = new Vector(Math.cos(rads), 0, Math.sin(rads)).normalize().multiply(multiplier).setY(0.1);
        return loc.add(v);
    }
}
