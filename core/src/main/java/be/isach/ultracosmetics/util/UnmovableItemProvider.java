package be.isach.ultracosmetics.util;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public interface UnmovableItemProvider {
    /**
     * @return Player to handle, or null if all players
     */
    public Player getPlayer();

    public boolean itemMatches(ItemStack stack);

    public void handleDrop(PlayerDropItemEvent event);

    /**
     * Slot the item should be in.
     * If the item is noticed in the wrong slot, {@link #moveItem(int, Player)} will be called.
     *
     * @return
     */
    public int getSlot();

    public void moveItem(int slot, Player player);

    public void handleInteract(PlayerInteractEvent event);

    public default void handleClick(Player player) {
    }
}
