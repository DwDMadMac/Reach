package net.ezenity.reach.Fx.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.Fx.Portals;
import net.ezenity.reach.Main;
import net.ezenity.reach.util.build.Spawn;
import org.bukkit.entity.Player;

/**
 * Initial Provider
 *<p>
 * This is the class where all the items are added to the inventory for the
 * initial provider before breaking down into the sub-inventories.
 *
 * @author Ezenity
 * @version 1.2.0
 * @since 0.0.1
 */
public class Initial implements InventoryProvider {
    /**
     * Spawned Item. Generates an ItemStack that is set within the configuration file. This
     * is used for setting the selected item icon inside the main portal.
     */
    private final Spawn spawnItem = new Spawn();

    /**
     * Main Reach Portal.
     *
     * This is the custom inventory for the Main Reach Portal. When a user types the command
     * 'reach' or 'reach main' this portal will appear with options that will allow them to
     * select a various of other custom inventories. Some of the other custom inventories are
     * 'Tools Portal', 'Weapons Portal' and so on. This will be the foundation before going
     * further into what Reach plugin has to offer.
     *
     * @param player get the player that is interacting with the main reach portal.
     * @param inventoryContents set the item icons inside the main reach portal.
     */
    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        /*
         * Close Inventory (Apple)
         */
        inventoryContents.set(0,0, ClickableItem.of( spawnItem.create("main.close-inventory"), e -> player.closeInventory() ));

        /*
         * Open Tools Portal
         */
        inventoryContents.set(0,2,ClickableItem.of( spawnItem.create("main.tools-portal"), e -> Portals.TOOLS_INVENTORY.open(player) ));

        /*
         * Open Weapons Portal
         *
         * TODO: Create Weapons Portal
         */
    }

    /**
     * Update inventory in iterations. Currently not using with this portal.
     *
     * @param player get player
     * @param inventoryContents get/set inventory contents
     */
    @Override
    public void update(Player player, InventoryContents inventoryContents) {}
}
