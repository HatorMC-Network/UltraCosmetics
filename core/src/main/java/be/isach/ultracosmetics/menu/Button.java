package be.isach.ultracosmetics.menu;

import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.inventory.ItemStack;

public interface Button {
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer);

    public void onClick(ClickData clickData);
}
