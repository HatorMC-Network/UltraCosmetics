package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.menu.CosmeticMenu;
import be.isach.ultracosmetics.player.UltraPlayer;

public abstract class ChangePageButton implements Button {
    private final int modifier;

    public ChangePageButton(int modifier) {
        this.modifier = modifier;
    }

    @Override
    public void onClick(ClickData clickData) {
        if (!(clickData.getMenu() instanceof CosmeticMenu)) {
            return;
        }
        UltraPlayer player = clickData.getClicker();
        CosmeticMenu<?> menu = (CosmeticMenu<?>) clickData.getMenu();
        menu.open(player, menu.getCurrentPage(player) + modifier);
    }
}
