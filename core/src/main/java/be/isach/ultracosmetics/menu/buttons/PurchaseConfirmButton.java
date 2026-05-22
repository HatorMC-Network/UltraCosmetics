package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.economy.EconomyHandler;
import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.menu.PurchaseData;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;

public class PurchaseConfirmButton implements Button {
    private final PurchaseData purchaseData;
    private final EconomyHandler eh;

    public PurchaseConfirmButton(PurchaseData purchaseData, EconomyHandler eh) {
        this.purchaseData = purchaseData;
        this.eh = eh;
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        return ItemFactory.create(XMaterial.EMERALD_BLOCK, MessageManager.getMessage("Purchase"));
    }

    @Override
    public void onClick(ClickData clickData) {
        UltraPlayer player = clickData.getClicker();
        player.getBukkitPlayer().closeInventory();
        if (!purchaseData.canPurchase()) return;
        eh.withdrawWithDiscount(player.getBukkitPlayer(), purchaseData.getBasePrice(), () -> {
            player.sendMessage(MessageManager.getMessage("Successful-Purchase"));
            purchaseData.runOnPurchase();
        }, () -> {
            player.sendMessage(MessageManager.getMessage("Not-Enough-Money"));
        });
    }
}
