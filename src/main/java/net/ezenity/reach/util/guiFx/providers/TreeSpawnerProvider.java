package net.ezenity.reach.util.guiFx.providers;

import com.destroystokyo.paper.block.TargetBlockInfo;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.Logger;
import net.ezenity.reach.util.guiFx.SpawnedItem;
import net.ezenity.reach.util.particleFx.ParticleSpawnedTask;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;

import java.util.Objects;

/**
 * Tree Spawner Options Provider
 * <p>
 * This provider is the class for implementing the options available for
 * the Tree Spawner Tool. This will allow a user to select the available
 * option and have it spawn the block that the user has clicked with the
 * Tree Spawner Tool in main hand.
 */
public class TreeSpawnerProvider implements InventoryProvider {
    /**
     * Spawned Item. Generates an ItemStack that is set within the configuration files.
     */
    private final SpawnedItem spawnedItem = new SpawnedItem();

    /**
     * Tree Spawner Options Portal.
     * <p>
     * This is the custom inventory for the Tree Spawner Tool. When a user selects
     * the tree Spawner Tool, they will then select(click) a block that they want
     * to spawn a tree type on. Once that user has clicked a block the Tree Spawner
     * Options Portal will appear with the following inventory contents. When a
     * option is selected the portal will close, the Tree Spawner Tool will be removed
     * from the players inventory and that tree type will generate with a custom
     * particle effect and a custom sound.
     *
     * TODO: Create config settings for: item row/column, enable status
     * TODO: Add color to item title based on enable status, (if/else) statement
     *
     * @param player get the player that is interacting with the custom portal
     * @param inventoryContents set the tree types inside the Tree Spawner Options portal
     */
    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        TargetBlockInfo blockInfo = player.getTargetBlockInfo(10); // Paper-API
        Location relativeBlock = Objects.requireNonNull(blockInfo).getRelativeBlock().getLocation(); // Paper-API
        Particle particleType = Particle.EXPLOSION_HUGE;
        String particleDesign = "explode";
        /*
         * Acacia Tree Type
         */
        inventoryContents.set(0,0,
                ClickableItem.of(
                        spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.acacia"),
                        e -> spawnTree(player, TreeType.ACACIA, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN, 1))
        );
        /*
         * Birch Tree Type
         */
        inventoryContents.set(0,1,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.birch"),
                        e -> spawnTree(player, TreeType.BIRCH, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN, 1))
        );
        /*
         * Tall Birch Tree Type
         */
        inventoryContents.set(0,2,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.dark-oak"),
                        e -> spawnTree(player, TreeType.TALL_BIRCH, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN, 1))
        );
        /*
         * Spruce Tree Type
         */
        inventoryContents.set(0,3,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.spruce"),
                        e -> spawnTree(player, TreeType.REDWOOD, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN, 1))
        );
        /*
         * Jungle Bush Tree Type
         */
        inventoryContents.set(0,4,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.jungle-bush"),
                        e -> spawnTree(player, TreeType.JUNGLE_BUSH, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN, 1))
        );
        /*
         * Small Jungle Tree Type
         */
        inventoryContents.set(0,5,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.small-jungle"),
                        e -> spawnTree(player, TreeType.SMALL_JUNGLE, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN, 1))
        );
        /*
         * Jungle Tree Type
         */
        inventoryContents.set(0,6,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.jungle"),
                        e -> spawnTree(player, TreeType.JUNGLE, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN, 1))
        );
        /*
         * Oak Tree Type
         */
        inventoryContents.set(0,7,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.oak"),
                        e -> spawnTree(player, TreeType.TREE, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN, 1))
        );
        /*
         * Big Oak Tree Type
         */
        inventoryContents.set(0,8,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.big-oak"),
                        e -> spawnTree(player, TreeType.BIG_TREE, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN, 1))
        );
        /*
         * Dark Oak Tree Type
         */
        inventoryContents.set(1,0,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.dark-oak"),
                        e -> spawnTree(player, TreeType.DARK_OAK, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN, 1))
        );
        /*
         * Cocoa Tree Type
         */
        inventoryContents.set(1,1,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.cocoa"),
                        e -> spawnTree(player, TreeType.COCOA_TREE, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN, 1))
        );
        /*
         * Swamp Tree Type
         */
        inventoryContents.set(1,2,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.swamp"),
                        e -> spawnTree(player, TreeType.SWAMP, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN, 1))
        );
        /*
         * Chorus Plant Tree Type
         */
        inventoryContents.set(1,3,
                ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.chorus-plant"),
                e -> {
                    if (blockInfo.getBlock().getType() != Material.END_STONE){
                        Lang.send(player, "&4ERROR&f:&7 To spawn a &dChorus Plant&7, the clicked block must be an &6End Stone&7.");
                        player.closeInventory();
                        return;
                    }

                    spawnTree(player, TreeType.CHORUS_PLANT, particleType, relativeBlock, particleDesign, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN, 1);
                }));

        // TODO: Brown Mushroom, Crimson Fungus, Mega Redwood, Red Mushroom, Tall redwood, Warped Fungus
    }

    /**
     * Update inventory in iterations. Currently not using with this portal.
     *
     * @param player get player
     * @param inventoryContents get inventory contents
     */
    @Override
    public void update(Player player, InventoryContents inventoryContents) {}

    /**
     * Spawn Tree. To prevent duplication, this method was created to spawn a tree type and the
     * corresponding particle. You will be able to set the tree type (although it is better to
     * leave the default settings), particle type, location of the particle spawned, particle
     * design, cooldown for the selected tree type and how long you want that specific particle
     * to be spawned for.
     * <p>
     * The location of the spawning tree type will be the selected block that the user clicks.
     * If that specific tree type requires a specific block to spawn on, the tree type will not
     * spawn unless that block is present. The user will also be notified of the proper block
     * that needs to be present to spawn the selected tree type that user is trying to spawn.
     *
     * @param player get player spawning tree type
     * @param treeType get selected tree type
     * @param particle get set particle type
     * @param location set location of particle spawning and tree spawning
     * @param particleDesign get the particle design from particles class
     * @param coolDown set cooldown for the specific spawned tree in seconds
     * @param particleSpawnedTimer set how long the particle will be spawned for in seconds
     */
    private void spawnTree(Player player, TreeType treeType, Particle particle, Location location, String particleDesign, int coolDown, int particleSpawnedTimer) {
        player.getWorld().generateTree(location, treeType);
        player.closeInventory();
        ParticleSpawnedTask.setParticleTask(
                player,
                particle,
                location,
                particleDesign,
                coolDown,
                particleSpawnedTimer
        );
        Logger.debug("Item in " + player.getDisplayName() + "'s hand is a: " + player.getInventory().getItemInMainHand().getType().toString());
        // TODO: Make option for timed usage, instead of one time usage & add to param
        player.getInventory().getItemInMainHand().setAmount(0);
    }
}
