package be.isach.ultracosmetics.events;

import be.isach.ultracosmetics.cosmetics.Cosmetic;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class UCCosmeticUnequipEvent extends UCCosmeticEvent {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public UCCosmeticUnequipEvent(UltraPlayer player, Cosmetic<?> cosmetic) {
        super(player, cosmetic);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
