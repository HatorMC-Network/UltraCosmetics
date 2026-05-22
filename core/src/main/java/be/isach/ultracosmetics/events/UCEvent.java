package be.isach.ultracosmetics.events;

import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public abstract class UCEvent extends Event {
    private final UltraPlayer player;

    public UCEvent(UltraPlayer player) {
        this.player = player;
    }

    public UltraPlayer getUltraPlayer() {
        return player;
    }

    public Player getPlayer() {
        return player.getBukkitPlayer();
    }
}
