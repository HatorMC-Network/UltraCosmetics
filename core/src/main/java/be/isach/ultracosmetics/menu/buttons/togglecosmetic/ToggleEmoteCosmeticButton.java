package be.isach.ultracosmetics.menu.buttons.togglecosmetic;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.EmoteType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.inventory.meta.ItemMeta;

public class ToggleEmoteCosmeticButton extends ToggleCosmeticButton {
    public ToggleEmoteCosmeticButton(UltraCosmetics ultraCosmetics, EmoteType cosmeticType) {
        super(ultraCosmetics, cosmeticType);
    }

    @Override
    protected ItemMeta modifyMeta(ItemMeta meta, UltraPlayer ultraPlayer) {
        EmoteType emoteType = (EmoteType) cosmeticType;
        ItemMeta emoteMeta = emoteType.getFrames().get(emoteType.getMaxFrames() - 1).getItemMeta();
        emoteMeta.setDisplayName(meta.getDisplayName());
        emoteMeta.setLore(meta.getLore());
        return emoteMeta;
    }
}
