package net.ezenity.reach.util.guiFx;

import fr.minuskube.inv.SmartInventory;
import net.ezenity.reach.util.guiFx.providers.MainProvider;
import net.ezenity.reach.util.guiFx.providers.ToolsProvider;
import net.ezenity.reach.util.guiFx.providers.TreeSpawnerProvider;

/**
 * List of Portals. An easy location for creating portals and keeping everything organized.
 * Each child portal will be listed under its parent portal.
 */
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
     * Tree Spawner Options Portal
     *
     * This inventory will be the foundation of all the tree spawner options. Displaying a list of
     * all available tree types that a user may spawn. By selecting one of the available inventory
     * contents, this selected inventory content will then spawn where that user has clicked with
     * the Tree Spawner Tool.
     */
    public static final SmartInventory TOOLS_TREE_SPAWNER_INVENTORY = SmartInventory.builder()
            .id("treeSpawnerPortal")
            .provider(new TreeSpawnerProvider())
            .parent(TOOLS_INVENTORY)
            .size(2,9)
            .title("Tree Spawner Options")
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
