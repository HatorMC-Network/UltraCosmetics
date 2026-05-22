package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.menu.PurchaseData;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;

public class PurchaseCancelButton implements Button {
    private final PurchaseData purchaseData;

    public PurchaseCancelButton(PurchaseData purchaseData) {
        this.purchaseData = purchaseData;
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        return ItemFactory.create(XMaterial.REDSTONE_BLOCK, MessageManager.getMessage("Cancel"));
    }

    @Override
    public void onClick(ClickData clickData) {
        purchaseData.runOnCancel();
    }
}
