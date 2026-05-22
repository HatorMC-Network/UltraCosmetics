package be.isach.ultracosmetics.worldguard;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.player.UltraPlayer;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.BukkitPlayer;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.SetFlag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.session.MoveType;
import com.sk89q.worldguard.session.Session;
import com.sk89q.worldguard.session.handler.Handler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CosmeticFlagHandler extends Handler {
    private static final Set<Category> ALL_CATEGORIES = new HashSet<>();

    static {
        ALL_CATEGORIES.addAll(Arrays.asList(Category.values()));
    }

    private final UltraCosmetics ultraCosmetics = UltraCosmeticsData.get().getPlugin();
    private final StateFlag cosmeticsFlag;
    private final StateFlag showroomFlag;
    private final SetFlag<Category> categoryFlag;
    private Set<Category> lastCategoryFlagValue = null;
    private Boolean lastShowroomFlagValue;

    protected CosmeticFlagHandler(Session session, StateFlag cosmeticsFlag, StateFlag showroomFlag, SetFlag<Category> categoryFlag) {
        super(session);
        this.cosmeticsFlag = cosmeticsFlag;
        this.showroomFlag = showroomFlag;
        this.categoryFlag = categoryFlag;
    }

    @Override
    public boolean onCrossBoundary(LocalPlayer player, Location from, Location to, ApplicableRegionSet toSet, Set<ProtectedRegion> entered, Set<ProtectedRegion> exited, MoveType moveType) {
        // borrowed from FlagValueChangeHandler
        // sets don't include global regions - check if those changed
        if (entered.isEmpty() && exited.isEmpty() && from.getExtent().equals(to.getExtent())) {
            return true; // no changes to flags if regions didn't change
        }
        // ensure player is a real player and not an NPC
        if (Bukkit.getPlayer(player.getUniqueId()) == null) return true;

        Player bukkitPlayer = ((BukkitPlayer) player).getPlayer();
        UltraPlayer ultraPlayer = ultraCosmetics.getPlayerManager().getUltraPlayer(bukkitPlayer);
        State currentValue = toSet.queryState(player, cosmeticsFlag);
        if (currentValue == State.DENY) {
            ultraCosmetics.getWorldGuardManager().noCosmeticsRegionEntered(ultraPlayer);
            // This is effectively what DENY represents for the `uc-cosmetics` flag
            lastCategoryFlagValue = ALL_CATEGORIES;
            return true;
        }
        Set<Category> categoryValue = toSet.queryValue(player, categoryFlag);
        Set<Category> needsUpdating = compareSets(categoryValue, lastCategoryFlagValue);
        ultraCosmetics.getWorldGuardManager().restrictedCosmeticsChange(ultraPlayer, needsUpdating);
        // [== ALLOW] is NOT the same as [!= DENY], queryState returns null if unset.
        boolean newShowroomState = toSet.queryState(player, showroomFlag) == State.ALLOW;
        if (lastShowroomFlagValue == null || lastShowroomFlagValue != newShowroomState) {
            ultraCosmetics.getWorldGuardManager().showroomFlagChange(ultraPlayer, newShowroomState);
            lastShowroomFlagValue = newShowroomState;
        }
        lastCategoryFlagValue = categoryValue;
        return true;
    }

    /**
     * Returns any values in currentSet that are not in previousSet,
     * or an empty set if no comparison is required.
     *
     * @param currentSet The active set of categories
     * @param lastSet    The last known active set of categories
     * @return a set containing any Categories not present in previousSet
     */
    private Set<Category> compareSets(Set<Category> currentSet, Set<Category> lastSet) {
        Set<Category> newValues = new HashSet<>();
        if (currentSet == null) return newValues;
        if (lastSet == null) return currentSet;
        newValues.addAll(currentSet);
        newValues.removeAll(lastSet);
        return newValues;
    }
}
