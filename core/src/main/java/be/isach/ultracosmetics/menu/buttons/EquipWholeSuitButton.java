package be.isach.ultracosmetics.menu.buttons;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.suits.ArmorSlot;
import be.isach.ultracosmetics.cosmetics.type.SuitCategory;
import be.isach.ultracosmetics.cosmetics.type.SuitType;
import be.isach.ultracosmetics.menu.Button;
import be.isach.ultracosmetics.menu.ClickData;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XMaterial;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EquipWholeSuitButton implements Button {
    private final SuitCategory category;
    private final Component name;
    private final String lore = MessageManager.getLegacyMessage("Suits.Whole-Equip-Lore");
    private final UltraCosmetics ultraCosmetics;

    public EquipWholeSuitButton(SuitCategory category, UltraCosmetics ultraCosmetics) {
        this.category = category;
        this.name = MessageManager.getMessage("Suits." + category.getConfigName() + ".whole-equip");
        this.ultraCosmetics = ultraCosmetics;
    }

    @Override
    public ItemStack getDisplayItem(UltraPlayer ultraPlayer) {
        ItemStack wholeEquipStack = XMaterial.HOPPER.parseItem();
        ItemMeta wholeEquipMeta = wholeEquipStack.getItemMeta();
        Component displayName = Component.empty().append(Category.SUITS_HELMET.getActivateTooltip()).appendSpace().append(name);
        wholeEquipMeta.setDisplayName(MessageManager.toLegacy(displayName));
        wholeEquipMeta.setLore(Arrays.asList("", lore, ""));
        wholeEquipStack.setItemMeta(wholeEquipMeta);
        return wholeEquipStack;
    }

    @Override
    public void onClick(ClickData clickData) {
        UltraPlayer player = clickData.getClicker();
        for (ArmorSlot armorSlot : ArmorSlot.values()) {
            SuitType type = category.getPiece(armorSlot);
            if (player.canEquip(type)) {
                if (player.hasCosmetic(type.getCategory()) && player.getCosmetic(type.getCategory()).getType() == type) {
                    continue;
                }
                type.equip(player, ultraCosmetics);
            }
        }
        if (UltraCosmeticsData.get().shouldCloseAfterSelect()) {
            player.getBukkitPlayer().closeInventory();
        } else {
            clickData.getMenu().refresh(player);
        }
    }
}
