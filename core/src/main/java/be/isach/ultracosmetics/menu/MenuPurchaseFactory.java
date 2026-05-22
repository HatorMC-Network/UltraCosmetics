package be.isach.ultracosmetics.menu;

import be.isach.ultracosmetics.UltraCosmetics;
import net.kyori.adventure.text.Component;

@FunctionalInterface
public interface MenuPurchaseFactory {
    public MenuPurchase createPurchaseMenu(UltraCosmetics ultraCosmetics, Component name, PurchaseData purchaseData);
}
