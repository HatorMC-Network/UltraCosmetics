package be.isach.ultracosmetics.util;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * InventoryView changed from a class to an interface in 1.21,
 * which causes issues when its methods are used directly.
 * This utility class uses reflection to access it without errors.
 * <a href="https://pastebin.com/EjmNLVZy">Sample error caused by the non-use of this class</a>
 */
public class InventoryViewHelper {
    private static final Method getTypeMethod;
    private static final Method getTopInventoryMethod;

    static {
        Method method = null;
        try {
            method = InventoryView.class.getMethod("getType");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        getTypeMethod = method;
        method = null;
        try {
            method = InventoryView.class.getMethod("getTopInventory");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        getTopInventoryMethod = method;
    }

    private InventoryViewHelper() {
    }

    public static InventoryType getType(Player player) {
        try {
            return (InventoryType) getTypeMethod.invoke(player.getOpenInventory());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static Inventory getTopInventory(Player player) {
        try {
            return (Inventory) getTopInventoryMethod.invoke(player.getOpenInventory());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
