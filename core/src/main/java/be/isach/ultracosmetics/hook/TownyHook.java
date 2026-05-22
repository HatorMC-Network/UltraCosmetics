package be.isach.ultracosmetics.hook;

import com.palmergames.bukkit.towny.event.MobRemovalEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownyHook implements Listener {
    @EventHandler
    public void onMobRemove(MobRemovalEvent event) {
        if (event.getEntity().hasMetadata("Mount") || event.getEntity().hasMetadata("Pet")) {
            event.setCancelled(true);
        }
    }
}
