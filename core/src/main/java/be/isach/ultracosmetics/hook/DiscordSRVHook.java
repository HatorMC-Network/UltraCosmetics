package be.isach.ultracosmetics.hook;

import be.isach.ultracosmetics.config.SettingsManager;
import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.EmbedBuilder;
import github.scarsz.discordsrv.dependencies.jda.api.MessageBuilder;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Message;
import github.scarsz.discordsrv.dependencies.jda.api.entities.MessageEmbed;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DiscordSRVHook {

    public void sendLootMessage(Player player, String format) {
        MessageEmbed embed = new EmbedBuilder().setAuthor(ChatColor.stripColor(format), null, DiscordSRV.getAvatarUrl(player)).build();
        Message message = new MessageBuilder().setEmbeds(embed).build();
        TextChannel channel = DiscordUtil.getTextChannelById(SettingsManager.getConfig().getString("DiscordSRV-Loot-Channel"));
        DiscordUtil.queueMessage(channel, message);
    }
}
