package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.inventory.ItemStack;

public class PreviousPageButton extends ChangePageButton {
    private final ItemStack stack = ItemFactory.rename(ItemFactory.getItemStackFromConfig("Categories.Previous-Page-Item"),
            MessageManager.getMessage("Menu.Misc.Button.Previous-Page"));

    public PreviousPageButton() {
        super(-1);
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        return stack;
    }
}
