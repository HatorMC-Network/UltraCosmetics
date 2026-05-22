package be.isach.ultracosmetics.menu.menus;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.type.ProjectileEffectType;
import be.isach.ultracosmetics.menu.CosmeticMenu;

public class MenuProjectileEffects extends CosmeticMenu<ProjectileEffectType> {

    public MenuProjectileEffects(UltraCosmetics ultraCosmetics) {
        super(ultraCosmetics, Category.PROJECTILE_EFFECTS);
    }

}
