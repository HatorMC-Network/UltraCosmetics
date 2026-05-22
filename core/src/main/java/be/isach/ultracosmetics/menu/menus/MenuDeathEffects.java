package be.isach.ultracosmetics.menu.menus;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.type.DeathEffectType;
import be.isach.ultracosmetics.menu.CosmeticMenu;

public class MenuDeathEffects extends CosmeticMenu<DeathEffectType> {

    public MenuDeathEffects(UltraCosmetics ultraCosmetics) {
        super(ultraCosmetics, Category.DEATH_EFFECTS);
    }

}
