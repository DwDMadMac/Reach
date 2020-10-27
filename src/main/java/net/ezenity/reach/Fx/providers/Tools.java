package net.ezenity.reach.Fx.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.Fx.Portals;
import net.ezenity.reach.Main;
import net.ezenity.reach.util.build.Spawn;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import org.bukkit.entity.Player;

/**
 * Tools Provider
 * <p>
 * This provider is the class for implementing tool inventory items. Here
 * will also contain information to what will happen next when a user
 * clicks one of the tool items.
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 0.0.1
 */
public class Tools extends Portals implements InventoryProvider {
    /**
     * Spawned Item. Generates an ItemStack that is set within the configuration file. This is used
     * for setting the tools inside the Tools Portal.
     */
    private final Spawn spawnItem = new Spawn();

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
        inventoryContents.set(0,0, ClickableItem.of( spawnItem.create("tools.tree-spawner"), e -> {
            // Check if target has permissions TODO: Create abstract solution
            if (!player.hasPermission("command.reach.portal.tools.treeSpawner")) {
                Main.getReachLogger().debug("onToolsPortalClick | " + player.getDisplayName() + " Does not have permission to use the Tree Spawner Tool. Return");
                // TODO Create lang for message
                Main.getReachLang().send(player, Main.getReachLang().COMMAND_NO_PERMISSION
                        .replace("{getCommand}", "Tree Spawner"));
                return;
            }

            // Check if the tree Spawner tool is enabled TODO: Create abstract solution
            if (!Main.getReachConfig().TREE_SPAWNER_ENABLED) {
                Main.getReachLogger().debug("onToolsPortalClick | " + player.getDisplayName() + " clicked Tree Spawner tool, however it is disabled. Closing inventory");
                Main.getReachLogger().info(player.getDisplayName() + "&2 clicked Tree Spawner when it was disabled, closed inventory.");
                player.closeInventory();
                Main.getReachLang().send(player, Main.getReachLang().DISABLED_COMMAND
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
            spawnItem.set(
                    player,
                    "tools.tree-spawner.spawned",
                    Main.getReachConfig().TREE_SPAWNER_SPAWNED_IDENTIFIER
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
