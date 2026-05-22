package be.isach.ultracosmetics.worldguard;

// has to be outside IFlagManager because IFlagManager cannot load if WorldGuard is not present
public enum CosmeticRegionState {
    BLOCKED_ALL,
    BLOCKED_CATEGORY,
    ALLOWED,
}