package be.isach.ultracosmetics.treasurechests.loot;

import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.TreasureChest;
import be.isach.ultracosmetics.util.WeightedSet;

public class CommandLootContainer implements Loot {
    private final WeightedSet<CommandLoot> loot = new WeightedSet<>();

    @Override
    public LootReward giveToPlayer(UltraPlayer player, TreasureChest chest) {
        return loot.getRandom().giveToPlayer(player, chest);
    }

    public void addCommandLoot(CommandLoot commandLoot, int weight) {
        loot.add(commandLoot, weight);
    }

    public int getSize() {
        return loot.size();
    }
}
