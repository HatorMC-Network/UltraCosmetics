package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.inventory.ItemStack;

public class NextPageButton extends ChangePageButton {
    private final ItemStack stack = ItemFactory.rename(ItemFactory.getItemStackFromConfig("Categories.Next-Page-Item"),
            MessageManager.getMessage("Menu.Misc.Button.Next-Page"));

    public NextPageButton() {
        super(1);
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        return stack;
    }

}
