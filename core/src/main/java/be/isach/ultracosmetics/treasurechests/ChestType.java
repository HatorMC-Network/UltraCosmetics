package be.isach.ultracosmetics.treasurechests;

import org.bukkit.Material;

/**
 * Created by Sacha on 11/11/15.
 */
@SuppressWarnings("unused")
public enum ChestType {

    NORMAL(Material.CHEST),
    ENDER(Material.ENDER_CHEST);

    private final Material type;

    private ChestType(Material type) {
        this.type = type;
    }

    public Material getType() {
        return type;
    }
}
