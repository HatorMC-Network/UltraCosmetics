package be.isach.ultracosmetics.listeners.legacy;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.function.BiFunction;

public class SpigotEntityDismountListener implements Listener {
    // getEntity(), getDismounted()
    private final BiFunction<Entity, Entity, Boolean> callback;

    public SpigotEntityDismountListener(BiFunction<Entity, Entity, Boolean> callback) {
        this.callback = callback;
    }

    @EventHandler
    public void onDismount(EntityDismountEvent event) {
        if (callback.apply(event.getEntity(), event.getDismounted())) {
            event.setCancelled(true);
        }
    }
}
