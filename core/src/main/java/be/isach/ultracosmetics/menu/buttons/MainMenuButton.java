package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.inventory.ItemStack;

public class MainMenuButton implements Button {
    private final ItemStack stack = ItemFactory.rename(ItemFactory.getItemStackFromConfig("Categories.Back-Main-Menu-Item"),
            MessageManager.getMessage("Menu.Main.Button.Name"));
    private final UltraCosmetics ultraCosmetics;

    public MainMenuButton(UltraCosmetics ultraCosmetics) {
        this.ultraCosmetics = ultraCosmetics;
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        return stack;
    }

    @Override
    public void onClick(ClickData clickData) {
        ultraCosmetics.getMenus().openMainMenu(clickData.getClicker());
    }
}
