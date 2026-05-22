package be.isach.ultracosmetics.cosmetics.mounts;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MountType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Material;
import org.bukkit.entity.Pig;

public class MountPig extends MountHeldItem {
    private static final Material CARROT_ON_A_STICK = XMaterial.CARROT_ON_A_STICK.get();

    public MountPig(UltraPlayer ultraPlayer, MountType type, UltraCosmetics ultraCosmetics) {
        super(ultraPlayer, type, ultraCosmetics);
    }

    @Override
    public void setupEntity() {
        ((Pig) entity).setSaddle(true);
    }

    @Override
    public Material getHeldItemMaterial() {
        return CARROT_ON_A_STICK;
    }
}
