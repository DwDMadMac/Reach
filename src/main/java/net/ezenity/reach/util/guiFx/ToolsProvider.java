package net.ezenity.reach.util.guiFx;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.util.particleFx.ParticleSpawnedTask;
import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

/**
 * ToolsProvider
 *
 * This provider is the class for implementing tools inventory items. Here
 * will also contain information to what will happen next when a user
 * clicks one of the tool items.
 */
public class ToolsProvider implements InventoryProvider {
    private final SpawnedItem spawnedItem = new SpawnedItem();
    private final ParticleSpawnedTask particleSpawnedTask = new ParticleSpawnedTask();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        // Tree Spawner Tool
        inventoryContents.set(0,0, ClickableItem.of( spawnedItem.getItem("tools.tree-spawner"), e -> {
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

            particleSpawnedTask.setParticleTask(
                    player,
                    Particle.DOLPHIN,
                    Config.TREE_SPAWNER_PARTICLE_DESIGN,
                    Config.TREE_SPAWNER_COOLDOWN,
                    Config.TREE_SPAWNER_PARTICLE_SPAWNED_TIMER
            );

            // Spawn custom item in players hand
            spawnedItem.setItem(
                    player,
                    "tools.tree-spawner.spawned",
                    Config.TREE_SPAWNER_SPAWNED_IDENTIFIER
            );
            spawnedItem.setInHand();

        } ));

        // TODO: Make Flower Spawner inventory contents
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
