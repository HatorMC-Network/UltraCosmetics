package be.isach.ultracosmetics.menu;

import be.isach.ultracosmetics.UltraCosmetics;
import net.kyori.adventure.text.Component;

public abstract class MenuPurchase extends Menu {
    protected final Component name;
    protected final PurchaseData purchaseData;

    public MenuPurchase(UltraCosmetics ultraCosmetics, Component name, PurchaseData purchaseData) {
        super("purchase", ultraCosmetics);
        this.purchaseData = purchaseData;
        this.name = name;
    }

    @Override
    protected int getSize() {
        return 54;
    }

    @Override
    protected Component getName() {
        return name;
    }
}
