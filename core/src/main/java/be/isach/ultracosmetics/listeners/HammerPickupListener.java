package be.isach.ultracosmetics.listeners;

import be.isach.ultracosmetics.cosmetics.gadgets.GadgetThorHammer;
import org.bukkit.event.Listener;

public class HammerPickupListener implements Listener {
    private GadgetThorHammer gadget;

    public HammerPickupListener(GadgetThorHammer gadget) {
        this.gadget = gadget;
    }


}
