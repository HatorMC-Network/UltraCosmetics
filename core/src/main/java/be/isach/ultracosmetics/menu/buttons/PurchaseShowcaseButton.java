package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.menu.PurchaseData;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.inventory.ItemStack;

public class PurchaseShowcaseButton implements Button {
    private final ItemStack displayItem;

    public PurchaseShowcaseButton(PurchaseData purchaseData) {
        this.displayItem = purchaseData.getShowcaseItem();
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        return displayItem;
    }

    @Override
    public void onClick(ClickData clickData) {
    }
}
