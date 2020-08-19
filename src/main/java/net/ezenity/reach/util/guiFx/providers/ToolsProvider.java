package net.ezenity.reach.util.guiFx.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.util.guiFx.SpawnedItem;
import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import org.bukkit.entity.Player;

/**
 * Tools Provider
 * <p>
 * This provider is the class for implementing tool inventory items. Here
 * will also contain information to what will happen next when a user
 * clicks one of the tool items.
 */
public class ToolsProvider implements InventoryProvider {
    /**
     * Spawned Item. Generates an ItemStack that is set within the configuration file. This is used
     * for setting the tools inside the Tools Portal.
     */
    private final SpawnedItem spawnedItem = new SpawnedItem();

    /**
     * Tools Portal.
     * <p>
     * This is the custom inventory for the Tools Portal. When a user selects a specific tool it will then
     * be placed in the players hand for further evaluation on the given tools characteristics.
     *
     * @param player get the player that is interacting with the custom portal.
     * @param inventoryContents set the tools inside the Tools Portal.
     */
    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        // Tree Spawner Tool
        inventoryContents.set(0,0, ClickableItem.of( spawnedItem.createItemStack("tools.tree-spawner"), e -> {
            // Check if target has permissions TODO: Create abstract solution
            if (!player.hasPermission("command.reach.portal.tools.treeSpawner")) {
                Logger.debug("onToolsPortalClick | " + player.getDisplayName() + " Does not have permission to use the Tree Spawner Tool. Return");
                // TODO Create lang for message
                Lang.send(player, Lang.COMMAND_NO_PERMISSION
                        .replace("{getCommand}", "Tree Spawner"));
                return;
            }

            // Check if the tree Spawner tool is enabled TODO: Create abstract solution
            if (!Config.TREE_SPAWNER_ENABLED) {
                Logger.debug("onToolsPortalClick | " + player.getDisplayName() + " clicked Tree Spawner tool, however it is disabled. Closing inventory");
                Logger.info(player.getDisplayName() + "&2 clicked Tree Spawner when it was disabled, closed inventory.");
                player.closeInventory();
                Lang.send(player, Lang.DISABLED_COMMAND
                        .replace("{getDisabledCommand}", "Tree Spawner"));
                return;
            }

//              USE THIS FOR FORCE FIELD WEAPON
//
//            ParticleSpawnedTask.setParticleTask(
//                    player,
//                    Particle.DOLPHIN,
//                    Config.TREE_SPAWNER_PARTICLE_DESIGN,
//                    Config.TREE_SPAWNER_COOLDOWN,
//                    Config.TREE_SPAWNER_PARTICLE_SPAWNED_TIMER
//            );

            // Spawn custom item in players hand
            spawnedItem.setItem(
                    player,
                    "tools.tree-spawner.spawned",
                    Config.TREE_SPAWNER_SPAWNED_IDENTIFIER
            );

            player.closeInventory();
        } ));


//        ItemStack test = new ItemStack(Material.ARROW);
//        inventoryContents.add(ClickableItem.of(test, e -> {
//            Portals.TOOLS_INVENTORY.getParent();
//        }));

        // TODO: Make Flower Spawner inventory contents
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
