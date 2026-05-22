package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.Updatable;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.MathUtils;
import com.cryptomorin.xseries.XSound;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public abstract class MorphFlightAbility extends Morph implements Updatable {
    private static final double COOLDOWN = 2;
    private final XSound.SoundPlayer sound;

    public MorphFlightAbility(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics, XSound sound) {
        super(owner, type, ultraCosmetics);
        this.sound = sound.record().withVolume(0.4f).soundPlayer().forPlayers(getPlayer());
    }

    @Override
    protected void onEquip() {
        super.onEquip();
        if (canUseSkill) {
            getPlayer().setAllowFlight(true);
        }
    }

    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        if (canUseSkill && event.getPlayer() == getPlayer()
                && event.getPlayer().getGameMode() != GameMode.CREATIVE
                && !event.getPlayer().isFlying()) {
            event.getPlayer().setFlying(false);
            event.setCancelled(true);
            if (!getOwner().canUse(getType())) return;
            Vector v = event.getPlayer().getLocation().getDirection();
            v.setY(0.75);
            MathUtils.applyVelocity(getPlayer(), v);
            sound.play();
            getOwner().setCooldown(getType(), COOLDOWN, 0);
        }
    }

    @Override
    public void onUpdate() {
        if (canUseSkill && UltraCosmeticsData.get().displaysCooldownInBar() && !getOwner().canUse(getType())) {
            getOwner().sendCooldownBar(getType(), COOLDOWN, 0);
        }
    }

    @Override
    public void onClear() {
        if (canUseSkill && getPlayer().getGameMode() != GameMode.CREATIVE) {
            getPlayer().setAllowFlight(false);
        }
    }
}
