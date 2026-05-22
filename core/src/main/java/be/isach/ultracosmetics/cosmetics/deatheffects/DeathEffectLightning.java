package be.isach.ultracosmetics.cosmetics.deatheffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.SettingsManager;
import be.isach.ultracosmetics.cosmetics.type.DeathEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.entity.Player;

public class DeathEffectLightning extends DeathEffect {

    private final boolean silent = SettingsManager.getConfig().getBoolean(getOptionPath("Silent"));

    public DeathEffectLightning(UltraPlayer owner, DeathEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void displayParticles() {
        Player player = getPlayer();
        player.getWorld().spigot().strikeLightningEffect(player.getLocation(), silent);
    }
}
