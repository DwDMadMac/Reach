package net.pl3x.reach.util.guiFx;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.pl3x.reach.Main;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.Logger;
import org.bukkit.entity.Player;

/**
 * ToolsProvider
 *
 * This provider is the class for implementing tools inventory items. Here
 * will also contain information to what will happen next when a user
 * clicks one of the tool items.
 */
public class ToolsProvider implements InventoryProvider {
    private PortalItem portalItem = new PortalItem();
    private Main plugin = Main.getInstance();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        // Tree Spawner Tool
        inventoryContents.set(0,0, ClickableItem.of( portalItem.getItem("tools.tree-spawner"), e -> {
            // Check if the tree Spawner tool is enabled
            if (!Config.TREE_SPAWNER_ENABLED){
                Logger.debug("onToolsPortalClick | " + player.getDisplayName() + " clicked Tree Spawner tool, however it is disabled. Closing inventory");
                player.closeInventory();
                // TODO: Create lang for message
                Lang.send(player, "Sorry, the Tree Spawner tool is disabled.");
                return;
            }

            // Check if target has permissions
            if (!player.hasPermission("command.reach.portal.tools.treeSpawner")){
                Logger.debug("onToolsPortalClick | " + player.getDisplayName() + " Does not have permission to use the Tree Spawner Tool. Return");
                // TODO Create lang for message
                Lang.send(player, "You do not have permission to use the Tree Spawner Tool.");
                return;
            }

            // Give player tree spawner tool
            // TODO: Create class/method for spawning in tools
            player.closeInventory();

            // TODO: Create particles effects
            // TODO: Create cool down for tool
        } ));

        // TODO: Make Flower Spawner inventory contents
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
