package net.ezenity.reach.listener;

import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.util.Logger;
import net.ezenity.reach.util.guiFx.Portals;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.Objects;

import static org.bukkit.Material.*;

/**
 * Tools Portal Event Listener Class. Here we will listen to all events that are associated with the
 * tools portal. If the Smart inventory is not able to handle a specific event, we will then fall
 * back to this class for events.
 */
public class ToolsListener implements Listener {

    /**
     * Validate block clicked
     * <p>
     * Verifies that the Tool is a "Tree Spawner". Once the Tool is verified it will sort through the options
     * with a new custom inventory for the player to select through.
     * <p>
     * Once the player selects the tree they are wanting to spawn the custom inventory will close and spawn it
     * on the block that the player clicked on. They "Tree Spawner" Tool will also be removed from the players
     * inventory.
     * <p>
     * Once the Tool is removed from the given player, the cool down for that tool will then begin.
     *
     * @param event player clicked block
     */
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onTreeSpawnerToolClick(PlayerInteractEvent event) {
        if (!Config.TREE_SPAWNER_ENABLED){
            Logger.info("&bonTreeSpawnerToolClick &f|&7 " + Config.TREE_SPAWNER_TITLE + " is disabled, cancelling event.");
            return;
        }

        if (event.getPlayer().getInventory().getItemInMainHand().getType() != Material.valueOf(Config.TREE_SPAWNER_SPAWNED_TYPE)){
            Logger.info("&bonTreeSpawnerToolClick &f|&7 The item type, " + event.getPlayer().getInventory().getItemInMainHand().getType() + ", does not match config option, cancelling event.");
            return;
        }

        if (!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData()){
            Logger.info("&bonTreeSpawnerToolClick &f|&7 Item in hand does not have any custom model data.");
            return;
        }

        int itemIdentity = event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData();

        if (itemIdentity != Config.TREE_SPAWNER_SPAWNED_IDENTIFIER) {
            Logger.info("&bOnTreeSpawnerClick &f|&7 The number identifier does not match the " + Config.TREE_SPAWNER_TITLE + " numeral identifier, cancelling event.");
            return;
        }

        event.setCancelled(true); // cancel all click events for tool.

        // TODO: Check for spawning ability -> Make sure tree can spawn in that specific location

        if (!Objects.requireNonNull(event.getClickedBlock()).getType().isBlock()) {
            Logger.info("&bonTreeSpawnerToolClick &f|&7 The click event is not a block, cancelling event.");
            return;
        }

        Material blockClicked = event.getClickedBlock().getType();
        boolean matchAnyListedMaterial = Arrays.asList(getMaterial()).contains(blockClicked);

        if (matchAnyListedMaterial) {
                Portals.TOOLS_TREE_SPAWNER_INVENTORY.open(event.getPlayer());
        } else {
            Logger.error("&bonTreeSpawnerToolClick &f|&7 Click block equals " + blockClicked.toString());
            Logger.error("&bonTreeSpawnerToolClick &f|&7 Block click does not equal the proper block, cancelling event.");
        }
    }

    /**
     * Get clicked material.
     * <p>
     * When a user clicks a material with the Tree Spawner Tool, this method will verify that the correct
     * block was clicked.
     *
     * @return Array of allowed clicked material for Tree Spawner Tool
     */
    private Material[] getMaterial(){
        return new Material[]{
                DIRT,
                GRASS_BLOCK,
                COARSE_DIRT,
                GRASS_PATH,
                PODZOL,
                FARMLAND,
                END_STONE
        };
    }
}
