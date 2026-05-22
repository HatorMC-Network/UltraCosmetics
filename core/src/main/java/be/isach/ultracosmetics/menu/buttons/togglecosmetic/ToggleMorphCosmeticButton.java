package be.isach.ultracosmetics.menu.buttons.togglecosmetic;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.config.MessageManager;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;

import java.util.List;

public class ToggleMorphCosmeticButton extends ToggleCosmeticButton {
    public ToggleMorphCosmeticButton(UltraCosmetics ultraCosmetics, MorphType cosmeticType) {
        super(ultraCosmetics, cosmeticType);
    }

    @Override
    protected void modifyLore(List<String> lore, UltraPlayer ultraPlayer) {
        MorphType morphType = (MorphType) cosmeticType;
        if (morphType.canUseSkill()) {
            lore.add("");
            lore.add(MessageManager.toLegacy(morphType.getSkill()));
        }
    }
}
