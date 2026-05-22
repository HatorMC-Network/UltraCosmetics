package be.isach.ultracosmetics.menu.menus;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.type.HatType;
import be.isach.ultracosmetics.menu.CosmeticMenu;

/**
 * Hat {@link be.isach.ultracosmetics.menu.Menu Menu}.
 *
 * @author iSach
 * @since 08-23-2016
 */
public class MenuHats extends CosmeticMenu<HatType> {

    public MenuHats(UltraCosmetics ultraCosmetics) {
        super(ultraCosmetics, Category.HATS);
    }
}
