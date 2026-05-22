package be.isach.ultracosmetics.treasurechests.loot;

import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.config.SettingsManager;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.type.CosmeticType;
import be.isach.ultracosmetics.events.loot.UCCosmeticRewardEvent;
import be.isach.ultracosmetics.permissions.PermissionManager;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.treasurechests.TreasureChest;
import be.isach.ultracosmetics.util.TextUtil;
import be.isach.ultracosmetics.util.WeightedSet;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CosmeticLoot implements Loot {
    private final Category category;
    private final WeightedSet<CosmeticType<?>> types = new WeightedSet<>();
    private final PermissionManager pm = UltraCosmeticsData.get().getPlugin().getPermissionManager();

    public CosmeticLoot(Category category, Player player) {
        this.category = category;
        for (CosmeticType<?> type : category.getEnabled()) {
            if (!type.isEnabled() || type.getChestWeight() < 1 || pm.hasPermission(player, type)) continue;
            types.add(type, type.getChestWeight());
        }
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public LootReward giveToPlayer(UltraPlayer player, TreasureChest chest) {
        CosmeticType<?> cosmetic = types.removeRandom();

        UCCosmeticRewardEvent event = new UCCosmeticRewardEvent(player, chest, this, cosmetic);
        Bukkit.getPluginManager().callEvent(event);

        String catName = category.getConfigPath();
        String[] name = MessageManager.getLegacyMessage("Treasure-Chests-Loot." + catName,
                Placeholder.component("cosmetic", cosmetic.getName())
        ).split("\n");
        pm.setPermission(player, cosmetic);
        boolean toOthers = SettingsManager.getConfig().getBoolean("TreasureChests.Loots." + catName + ".Message.enabled");
        Component message = MessageManager.getMessage("Treasure-Chests-Loot-Messages." + catName,
                Placeholder.component("cosmetic", TextUtil.filterPlaceholderColors(cosmetic.getName())),
                Placeholder.unparsed("name", player.getBukkitPlayer().getName())
        );
        return new LootReward(name, cosmetic.getItemStack(), message, toOthers, true, cosmetic);
    }

    @Override
    public boolean isEmpty() {
        return types.size() == 0;
    }
}
