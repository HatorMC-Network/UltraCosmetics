package be.isach.ultracosmetics.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.jetbrains.annotations.NotNull;

public class Discount implements Comparable<Discount> {
    private final double discount;
    private final Permission permission;

    public Discount(String name, double discount) {
        this.discount = discount;
        this.permission = new Permission("ultracosmetics.discount." + name, PermissionDefault.FALSE);
        try {
            Bukkit.getPluginManager().addPermission(permission);
        } catch (IllegalArgumentException ignored) {
        }
    }

    public double getDiscount() {
        return discount;
    }

    public Permission getPermission() {
        return permission;
    }

    public boolean hasPermission(Player player) {
        return player.hasPermission(permission);
    }

    @Override
    public int compareTo(@NotNull Discount o) {
        return Double.compare(discount, o.discount);
    }
}
