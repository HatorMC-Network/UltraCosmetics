package be.isach.ultracosmetics.events;

import be.isach.ultracosmetics.cosmetics.Cosmetic;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UCCosmeticEquipEvent extends UCCosmeticEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private boolean cancelled = false;

    public UCCosmeticEquipEvent(UltraPlayer player, Cosmetic<?> cosmetic) {
        super(player, cosmetic);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
