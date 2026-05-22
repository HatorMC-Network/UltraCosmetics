package be.isach.ultracosmetics.treasurechests.loot;

import be.isach.ultracosmetics.events.loot.UCCommandRewardEvent;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.CommandReward;
import be.isach.ultracosmetics.treasurechests.TreasureChest;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommandLoot implements Loot {
    private final CommandReward reward;

    public CommandLoot(CommandReward reward) {
        this.reward = reward;
    }

    public CommandReward getReward() {
        return reward;
    }

    @Override
    public LootReward giveToPlayer(UltraPlayer player, TreasureChest chest) {
        UCCommandRewardEvent event = new UCCommandRewardEvent(player, chest, this);
        Bukkit.getPluginManager().callEvent(event);

        Player bukkitPlayer = player.getBukkitPlayer();
        String playerName = bukkitPlayer.getName();
        for (String command : reward.getCommands()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%name%", playerName));
        }
        String[] name = new String[] {reward.getName()};

        return new LootReward(name, reward.getItemStack(), reward.getMessage(bukkitPlayer), reward.isMessageEnabled(), true);
    }

}
