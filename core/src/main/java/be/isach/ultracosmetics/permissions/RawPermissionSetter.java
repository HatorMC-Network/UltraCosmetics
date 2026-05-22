package be.isach.ultracosmetics.permissions;

import org.bukkit.entity.Player;

public interface RawPermissionSetter {
    public void setRawPermission(Player player, String permission);
}
