package be.isach.ultracosmetics.treasurechests;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.SettingsManager;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class StationaryChest {
    private final int chestCount = SettingsManager.getConfig().getInt("TreasureChests.Count", 4);
    private final Block chest;
    private final UltraCosmetics ultraCosmetics;
    private ItemBounceTask currentBounceTask;

    public StationaryChest(Block chest, UltraCosmetics ultraCosmetics) {
        this.chest = chest;
        this.ultraCosmetics = ultraCosmetics;
    }

    @EventHandler
    public void onClickChest(PlayerInteractEvent event) {
        if (event.getClickedBlock() != chest) return;
        event.setCancelled(true);
        UltraPlayer ultraPlayer = ultraCosmetics.getPlayerManager().getUltraPlayer(event.getPlayer());
        if (ultraPlayer.getKeys() < 1) {
            ultraCosmetics.getMenus().openKeyPurchaseMenu(ultraPlayer);
            return;
        }
        ultraPlayer.removeKey();
        TreasureRandomizer randomizer = new TreasureRandomizer(event.getPlayer(), chest.getLocation());
        TreasureChest.setLidPosition(chest, true);
        if (currentBounceTask != null) {
            currentBounceTask.stop();
        }
        currentBounceTask = new ItemBounceTask(this);
    }

    protected void bounceTaskFinished(ItemBounceTask bounceTask) {
        if (currentBounceTask == bounceTask) {
            currentBounceTask = null;
        }
    }
}
