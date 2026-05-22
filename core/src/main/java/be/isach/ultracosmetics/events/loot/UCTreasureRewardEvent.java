package be.isach.ultracosmetics.events.loot;

import be.isach.ultracosmetics.events.UCEvent;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.TreasureChest;
import be.isach.ultracosmetics.treasurechests.loot.Loot;

public abstract class UCTreasureRewardEvent extends UCEvent {
    private final TreasureChest chest;
    protected final Loot loot;

    public UCTreasureRewardEvent(UltraPlayer player, TreasureChest chest, Loot loot) {
        super(player);
        this.chest = chest;
        this.loot = loot;
    }

    /**
     * Returns the treasure chest associated with this event,
     * or null if no TreasureChest is associated (i.e. /uc reward).
     *
     * @return the associated TreasureChest
     */

    public TreasureChest getChest() {
        return chest;
    }

    /**
     * The loot object for this reward
     *
     * @return loot
     */
    public Loot getLoot() {
        return loot;
    }
}
