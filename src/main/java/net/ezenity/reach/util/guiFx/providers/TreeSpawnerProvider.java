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
     * Spawned Item. Generates an ItemStack that is set within the configuration files. This is
     * used for setting the Tree Spawner Tool Options inside the Tree Spawner Options Portal.
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
     * TODO: Add color to item title based on enable status, (if/else) statement
     * TODO: Add permission node per tree type
     *
     * @param player get the player that is interacting with the custom portal.
     * @param inventoryContents set the tree types inside the Tree Spawner Options portal.
     */
    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        TargetBlockInfo blockInfo = player.getTargetBlockInfo(10); // Paper-API
        Location relativeBlock = Objects.requireNonNull(blockInfo).getRelativeBlock().getLocation(); // Paper-API
        /*
         * Acacia Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_ROW,Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_COLUMN,
                ClickableItem.of(
                        spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.acacia"),
                        e -> spawnTree(player, "acacia.enabled", TreeType.ACACIA, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Birch Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.birch"),
                        e -> spawnTree(player, "birch.enabled", TreeType.BIRCH, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Tall Birch Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_ROW,Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.tall-birch"),
                        e -> spawnTree(player, "tall-birch.enabled", TreeType.TALL_BIRCH, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Spruce Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.spruce"),
                        e -> spawnTree(player, "spruce.enabled", TreeType.REDWOOD, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Jungle Bush Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.jungle-bush"),
                        e -> spawnTree(player, "jungle-bush.enabled", TreeType.JUNGLE_BUSH, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Small Jungle Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.small-jungle"),
                        e -> spawnTree(player, "small-jungle.enabled", TreeType.SMALL_JUNGLE, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Jungle Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.jungle"),
                        e -> spawnTree(player, "jungle.enabled", TreeType.JUNGLE, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Oak Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.oak"),
                        e -> spawnTree(player, "oak.enabled", TreeType.TREE, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Big Oak Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.big-oak"),
                        e -> spawnTree(player, "big-oak.enabled", TreeType.BIG_TREE, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Dark Oak Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.dark-oak"),
                        e -> spawnTree(player, "dark-oak.enabled", TreeType.DARK_OAK, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Cocoa Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.cocoa"),
                        e -> spawnTree(player, "cocoa.enabled", TreeType.COCOA_TREE, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Swamp Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.swamp"),
                        e -> spawnTree(player, "swamp.enabled", TreeType.SWAMP, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_SPAWNED_TIMER))
        );
        /*
         * Chorus Plant Tree Type
         */
        inventoryContents.set(Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_ROW, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_COLUMN,
                ClickableItem.of(spawnedItem.createItemStack("tools.tree-spawner.spawned.tool-portal.chorus-plant"),
                e -> {
                    if (blockInfo.getBlock().getType() != Material.END_STONE){
                        Lang.send(player, "&4ERROR&f:&7 To spawn a &dChorus Plant&7, the clicked block must be an &6End Stone&7.");
                        player.closeInventory();
                        return;
                    }

                    spawnTree(player, "chorus-plant.enabled", TreeType.CHORUS_PLANT, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_TYPE, relativeBlock, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_DESIGN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN, Config.TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_SPAWNED_TIMER);
                }));

        // TODO: Brown Mushroom, Crimson Fungus, Mega Redwood, Red Mushroom, Tall redwood, Warped Fungus
    }

    /**
     * Update inventory in iterations. Currently not using with this portal.
     *
     * @param player get player
     * @param inventoryContents get/set inventory contents
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
     * @param status get the status of the tree option
     * @param treeType get selected tree type
     * @param particle get the particle string from the config file
     * @param location set location of particle spawning and tree spawning
     * @param particleDesign get the particle design from particles class
     * @param coolDown set cooldown for the specific spawned tree in seconds
     * @param particleSpawnedTimer set how long the particle will be spawned for in seconds
     */
    private void spawnTree(Player player, String status, TreeType treeType, String particle, Location location, String particleDesign, int coolDown, int particleSpawnedTimer) {
        if (!spawnedItem.getConfigBoolean(Boolean.parseBoolean("portal.tools.tree-spawner.spawned.tool-portal" + status))) {
            Logger.debug("spawnTree &f|&7 The specified tree type option is disabled.");
            Lang.send(player, "&cThe option &4" + treeType.toString().toLowerCase().replace("_", " ") + " &cis currently disabled, please try another option.");
            player.closeInventory();
            return;
        }
        player.getWorld().generateTree(location, treeType);
        player.closeInventory();
        Particle getParticle = Particle.valueOf(particle.toUpperCase());
        ParticleSpawnedTask.setParticleTask(player, getParticle, location, particleDesign.toLowerCase(), coolDown, particleSpawnedTimer);
        Logger.debug("Item in " + player.getDisplayName() + "'s hand is a: " + player.getInventory().getItemInMainHand().getType().toString());
        player.getInventory().getItemInMainHand().setAmount(0); // TODO: Make option for timed usage, instead of one time usage & add to param
    }
}
