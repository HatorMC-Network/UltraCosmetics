package be.isach.ultracosmetics.events;

import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.Cosmetic;
import be.isach.ultracosmetics.cosmetics.type.CosmeticType;
import be.isach.ultracosmetics.player.UltraPlayer;

public abstract class UCCosmeticEvent extends UCEvent {

    private final Cosmetic<?> cosmetic;

    public UCCosmeticEvent(UltraPlayer player, Cosmetic<?> cosmetic) {
        super(player);
        this.cosmetic = cosmetic;
    }

    public Cosmetic<?> getCosmetic() {
        return cosmetic;
    }

    public CosmeticType<?> getCosmeticType() {
        return cosmetic.getType();
    }

    public Category getCategory() {
        return cosmetic.getCategory();
    }
}
