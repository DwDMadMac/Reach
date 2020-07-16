package net.ezenity.reach.util.guiFx;

import fr.minuskube.inv.SmartInventory;

public class Portals {
    /**
     * Main Inventory
     * <p>
     * This inventory will be the foundation of the Reach plugin. here will be a list of
     * the core components Reach offers.
     */
    public static final SmartInventory MAIN_INVENTORY = SmartInventory.builder()
            .id("mainPortal")
            .provider(new MainProvider())
            .size(1,9)
            .title("Reach Portal")
            .closeable(true)
            .build();

    /**
     * Tools Portal
     * <p>
     * This inventory will be the foundation of all the tools available for the Reach plugin. This
     * inventory may break off into separate inventories, or it may entice you with a custom tool. By
     * clicking one of the tools available which will be listed under the {@link ToolsProvider} you
     * will be either given the tool at hand or diverted to select its sub functions.
     */
    public static final SmartInventory TOOLS_INVENTORY = SmartInventory.builder()
            .id("toolsPortal")
            .provider(new ToolsProvider())
            .size(1,9)
            .title("Tools Portal")
            .closeable(true)
            .build();

    /**
     * Weapons Portal
     * <p>
     * This inventory will be the foundation of all the weapons available for the Reach plugin. This
     * inventory may break off into separate inventories, or it may entice you with a custom tool.
     * By clicking one of the weapons available which will be listed under the {@link WeaponsProvider}
     * you will be either given the weapon at hand or diverted to select its sub functions.
     */
    public static final SmartInventory WEAPONS_INVENTORY = SmartInventory.builder()
            .id("weaponsPortal")
            .provider(new WeaponsProvider())
            .size(1,9)
            .title("Weapons Portal")
            .closeable(true)
            .build();

}
