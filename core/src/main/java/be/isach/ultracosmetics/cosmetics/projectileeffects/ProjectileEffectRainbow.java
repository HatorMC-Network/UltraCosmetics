package be.isach.ultracosmetics.cosmetics.projectileeffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.ProjectileEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ColorUtils;
import org.bukkit.entity.Projectile;

public class ProjectileEffectRainbow extends ProjectileEffect {
    public ProjectileEffectRainbow(UltraPlayer owner, ProjectileEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }

    @Override
    public void showParticles(Projectile projectile) {
        display.withColor(ColorUtils.getRainbowColor(0.5)).spawn(projectile.getLocation());
    }
}
