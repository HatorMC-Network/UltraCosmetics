package be.isach.ultracosmetics.menu.buttons.togglecosmetic;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.PetType;
import be.isach.ultracosmetics.player.UltraPlayer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class TogglePetCosmeticButton extends ToggleCosmeticButton {
    public TogglePetCosmeticButton(UltraCosmetics ultraCosmetics, PetType cosmeticType) {
        super(ultraCosmetics, cosmeticType);
    }

    @Override
    protected Component modifyName(Component base, UltraPlayer ultraPlayer) {
        Component petName = ultraPlayer.getPetName((PetType) cosmeticType);
        if (petName == null) return base;
        return Component.empty().append(base).appendSpace().append(Component.text("(", NamedTextColor.GRAY))
                .append(petName).append(Component.text(")", NamedTextColor.GRAY));
    }
}
