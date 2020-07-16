package net.ezenity.reach.util.guiFx;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.entity.Player;

/**
 * Initial Provider
 *
 * This is the class where all the items are added to the inventory for the
 * initial provider before breaking down into the sub-inventories.
 */
public class MainProvider implements InventoryProvider {
    private PortalItem portalItem = new PortalItem();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        /*
         * Close Inventory (Apple)
         */
        inventoryContents.set(0,0, ClickableItem.of( portalItem.getItem("main.close-inventory"), e -> {
            player.closeInventory();
        }));

        /*
         * Open Tools Portal
         */
        inventoryContents.set(0,2,ClickableItem.of( portalItem.getItem("main.tools-portal"), e -> {
            Portals.TOOLS_INVENTORY.open(player);
        }));

        /*
         * Open Weapons Portal
         *
         * TODO: Create Weapons Portal
         */
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
