package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XSound;
import org.bukkit.event.player.PlayerInteractEvent;

public class MorphPlaySound extends MorphLeftClickCooldown {
    private final XSound.SoundPlayer sound;

    public MorphPlaySound(UltraPlayer owner, MorphType type, UltraCosmetics ultraCosmetics, XSound sound) {
        super(owner, type, ultraCosmetics, 0.5);
        this.sound = sound.record().publicSound(true).soundPlayer().forPlayers(getPlayer());
    }

    @Override
    public void onLeftClick(PlayerInteractEvent event) {
        event.setCancelled(true);
        sound.play();
    }
}
