package be.isach.ultracosmetics.events.loot;

import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.CommandReward;
import be.isach.ultracosmetics.treasurechests.TreasureChest;
import be.isach.ultracosmetics.treasurechests.loot.CommandLoot;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player receives command executions in a treasure chest.
 * (See TreasureChests.Loots.Commands in config)
 */
public class UCCommandRewardEvent extends UCTreasureRewardEvent {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public UCCommandRewardEvent(UltraPlayer player, TreasureChest chest, CommandLoot command) {
        super(player, chest, command);
    }

    @Override
    public CommandLoot getLoot() {
        return (CommandLoot) loot;
    }

    /**
     * Returns a CommandReward that can be modified
     * to change the message displayed and commands executed.
     *
     * @return the CommandReward
     */
    public CommandReward getCommand() {
        return ((CommandLoot) getLoot()).getReward();
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
