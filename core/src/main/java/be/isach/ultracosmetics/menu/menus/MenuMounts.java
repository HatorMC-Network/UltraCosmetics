package be.isach.ultracosmetics.menu.menus;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.type.MountType;
import be.isach.ultracosmetics.menu.CosmeticMenu;

/**
 * Mount {@link be.isach.ultracosmetics.menu.Menu Menu}.
 *
 * @author iSach
 * @since 08-23-2016
 */
public class MenuMounts extends CosmeticMenu<MountType> {

    public MenuMounts(UltraCosmetics ultraCosmetics) {
        super(ultraCosmetics, Category.MOUNTS);
    }

}
