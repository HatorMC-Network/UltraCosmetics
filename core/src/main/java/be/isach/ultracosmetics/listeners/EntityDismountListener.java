package be.isach.ultracosmetics.listeners;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.listeners.legacy.SpigotEntityDismountListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EntityDismountListener {
    private final Map<Object, BiFunction<Entity, Entity, Boolean>> handlers = new HashMap<>();

    public EntityDismountListener(UltraCosmetics ultraCosmetics) {
        SpigotEntityDismountListener listener = new SpigotEntityDismountListener((entity, dismounted) -> {
            boolean cancel = false;
            for (BiFunction<Entity, Entity, Boolean> callback : handlers.values()) {
                if (callback.apply(entity, dismounted)) {
                    cancel = true;
                }
            }
            return cancel;
        });
        Bukkit.getPluginManager().registerEvents(listener, ultraCosmetics);
    }

    public void addHandler(Object owner, BiFunction<Entity, Entity, Boolean> handler) {
        handlers.put(owner, handler);
    }

    public void removeHandler(Object owner) {
        if (handlers.remove(owner) == null) {
            throw new IllegalStateException("Handler not registered");
        }
    }
}
