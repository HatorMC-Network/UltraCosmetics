package be.isach.ultracosmetics.cosmetics.mounts;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MountType;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;

public class MountSlimeSnake extends MountFlyingSnake {
    private static final ItemStack SLIME_BLOCK = XMaterial.SLIME_BLOCK.parseItem();

    public MountSlimeSnake(UltraPlayer owner, MountType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics, SLIME_BLOCK);
    }

    @Override
    public void setupMainEntity() {
        ((Slime) entity).setSize(2);
    }
}
