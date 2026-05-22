package be.isach.ultracosmetics.util;

import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.config.SettingsManager;
import be.isach.ultracosmetics.version.VersionManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.function.Function;

public class Area {
    private final boolean DEBUG = SettingsManager.getConfig().getBoolean("Area-Debug");
    protected final World world;
    protected final int x1, y1, z1;
    protected final int x2, y2, z2;

    public Area(Location loc1, Location loc2) {
        if (loc1.getWorld() != loc2.getWorld()) {
            throw new IllegalArgumentException("Locations cannot be in different worlds");
        }
        this.world = loc1.getWorld();
        this.x1 = Math.min(loc1.getBlockX(), loc2.getBlockX());
        this.y1 = Math.min(loc1.getBlockY(), loc2.getBlockY());
        this.z1 = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        this.x2 = Math.max(loc1.getBlockX(), loc2.getBlockX());
        this.y2 = Math.max(loc1.getBlockY(), loc2.getBlockY());
        this.z2 = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
    }

    public Area(Location center, int radius, int yUp) {
        this(center.clone().add(-radius, 0, -radius), center.clone().add(radius, yUp, radius));
    }

    public static int findMaxY(Location center, int radius) {
        World world = center.getWorld();
        int maxY = VersionManager.getWorldMaxHeight(world);
        for (int y = center.getBlockY(); y <= maxY; y++) {
            for (int x = center.getBlockX() - radius; x <= center.getBlockX() + radius; x++) {
                for (int z = center.getBlockZ() - radius; z <= center.getBlockZ() + radius; z++) {
                    if (!BlockUtils.isAir(world.getBlockAt(x, y, z).getType())) {
                        return y - 1;
                    }
                }
            }
        }
        return maxY;
    }

    public int getHeight() {
        return y2 - y1;
    }

    /**
     * Checks each material in the area against okMatFunc,
     * and returns true if every block is "ok" accordingly.
     * <p>
     * Ignores the block at (badX, badY, badZ)
     *
     * @param badX      X coordinate of block to ignore
     * @param badY      Y coordinate of block to ignore
     * @param badZ      Z coordinate of block to ignore
     * @param okMatFunc A function that decides if a Material is OK to be there
     * @return true if every block matches okMatFunc
     */
    public boolean isEmptyExcept(int badX, int badY, int badZ, Function<Material, Boolean> okMatFunc) {
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    if (x == badX && y == badY && z == badZ) continue;
                    if (!okMatFunc.apply(world.getBlockAt(x, y, z).getType())) {
                        if (DEBUG) {
                            SmartLogger log = UltraCosmeticsData.get().getPlugin().getSmartLogger();
                            log.write("Failed area check at (" + x + "," + y + "," + z + ") because it is " + world.getBlockAt(x, y, z).getType());
                        }
                        return false;
                    }
                }
            }
        }
        if (DEBUG) {
            UltraCosmeticsData.get().getPlugin().getSmartLogger().write("Area check passed");
        }
        return true;
    }

    public boolean isEmptyExcept(Location loc) {
        return isEmptyExcept(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), BlockUtils::isAir);
    }

    public boolean isEmpty() {
        // no special meaning, but the loop will never make it that far
        return isEmptyExcept(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, BlockUtils::isAir);
    }

    // It's deprecated because it "does not have an implementation which is well linked to the underlying server,"
    // but that doesn't really matter for our purposes.
    @SuppressWarnings("deprecation")
    public boolean isTransparent() {
        return isEmptyExcept(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, m -> m.isTransparent() || BlockUtils.isAir(m));
    }

    public boolean contains(Block block) {
        return block.getWorld() == world && contains(block.getX(), block.getY(), block.getZ());
    }

    public boolean contains(int x, int y, int z) {
        return x >= x1 && x <= x2 && y >= y1 && y <= y2 && z >= z1 && z <= z2;
    }

    public boolean overlapsWith(Area area) {
        return rangesOverlap(area.x1, area.x2, x1, x2)
                && rangesOverlap(area.y1, area.y2, y1, y2)
                && rangesOverlap(area.z1, area.z2, z1, z2);
    }

    /**
     * Returns true if the ranges A and B overlap
     *
     * @param a1 lower bound of range A
     * @param a2 upper bound of range A
     * @param b1 lower bound of range B
     * @param b2 upper bound of range B
     * @return true if A and B overlap
     */
    private boolean rangesOverlap(int a1, int a2, int b1, int b2) {
        return a1 <= b2 && a2 >= b1;
    }

    @Override
    public String toString() {
        return "Area{x1=" + x1 + ",y1=" + y1 + ",z1=" + z1 + ",x2=" + x2 + ",y2=" + y2 + ",z2=" + z2 + "}";
    }
}
