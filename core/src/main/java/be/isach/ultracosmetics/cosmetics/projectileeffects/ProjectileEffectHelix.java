package be.isach.ultracosmetics.cosmetics.projectileeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ProjectileEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

public class ProjectileEffectHelix extends ProjectileEffect {
    private static final Vector Y_AXIS = new Vector(0, 1, 0);
    private static final double STEP = Math.PI / 8;
    private double angle = 0;

    public ProjectileEffectHelix(UltraPlayer owner, ProjectileEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }

    @Override
    public void showParticles(Projectile projectile) {
        angle += STEP;
        if (angle >= Math.PI * 2) angle %= Math.PI * 2;
        Vector vel = projectile.getVelocity();
        Vector particle = vel.clone().crossProduct(Y_AXIS).normalize().rotateAroundAxis(vel, angle);
        showHelix(projectile, projectile.getLocation().add(particle), projectile.getLocation().subtract(particle));
    }

    public void showHelix(Projectile projectile, Location a, Location b) {
        display.spawn(a);
        display.spawn(b);
    }
}
