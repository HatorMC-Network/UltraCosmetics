package be.isach.ultracosmetics.permissions;

import org.bukkit.entity.Player;

public interface RawPermissionGetter {
    public boolean hasRawPermission(Player player, String permission);
}
