package be.isach.ultracosmetics.cosmetics.mounts;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MountType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Strider;

public class MountStrider extends MountHeldItem {

    public MountStrider(UltraPlayer ultraPlayer, MountType type, UltraCosmetics ultraCosmetics) {
        super(ultraPlayer, type, ultraCosmetics);
    }

    @Override
    public void setupEntity() {
        ((Strider) entity).setSaddle(true);
    }

    @Override
    public Material getHeldItemMaterial() {
        return Material.WARPED_FUNGUS_ON_A_STICK;
    }
}
