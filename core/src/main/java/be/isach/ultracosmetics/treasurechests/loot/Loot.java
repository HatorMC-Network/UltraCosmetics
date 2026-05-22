package be.isach.ultracosmetics.treasurechests.loot;

import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.TreasureChest;

import java.util.concurrent.ThreadLocalRandom;

public interface Loot {
    public LootReward giveToPlayer(UltraPlayer player, TreasureChest chest);

    default int randomInRange(int min, int max) {
        if (min < max) {
            return ThreadLocalRandom.current().nextInt(max - min) + min;
        }
        return min;
    }

    public default boolean isEmpty() {
        return false;
    }
}
