package be.isach.ultracosmetics.treasurechests.loot;

import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.TreasureChest;
import com.cryptomorin.xseries.XMaterial;

public class NothingLoot implements Loot {

    @Override
    public LootReward giveToPlayer(UltraPlayer player, TreasureChest chest) {
        String[] name = MessageManager.getLegacyMessage("Treasure-Chests-Loot.Nothing").split("\n");
        return new LootReward(name, XMaterial.BARRIER.parseItem(), null, false, false);
    }

}
