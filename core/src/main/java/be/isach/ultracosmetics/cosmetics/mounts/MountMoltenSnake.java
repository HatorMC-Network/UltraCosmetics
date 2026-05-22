package be.isach.ultracosmetics.cosmetics.mounts;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MountType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.entity.MagmaCube;
import org.bukkit.inventory.ItemStack;

public class MountMoltenSnake extends MountFlyingSnake {
    private static final ItemStack NETHERRACK = XMaterial.NETHERRACK.parseItem();

    public MountMoltenSnake(UltraPlayer owner, MountType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, NETHERRACK);
    }

    @Override
    public void setupMainEntity() {
        ((MagmaCube) entity).setSize(2);
    }
}
