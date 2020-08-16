package net.ezenity.reach.util.guiFx.providers;

import com.destroystokyo.paper.block.TargetBlockInfo;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.util.Logger;
import net.ezenity.reach.util.guiFx.SpawnedItem;
import net.ezenity.reach.util.particleFx.ParticleSpawnedTask;
import org.bukkit.Location;
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
    private final SpawnedItem spawnedItem = new SpawnedItem();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {
        inventoryContents.set(0,0, ClickableItem.of(spawnedItem.getConfigItem("tools.tree-spawner.spawned.tool-portal.acacia"), e -> {
            TargetBlockInfo blockInfo = player.getTargetBlockInfo(10); // Paper-API
            Location relativeBlock = Objects.requireNonNull(blockInfo).getRelativeBlock().getLocation(); // Paper-API
            player.getWorld().generateTree(relativeBlock, TreeType.ACACIA);
            player.closeInventory();

            // TODO: Make config options
            ParticleSpawnedTask.setParticleTask(
                    player,
                    Particle.EXPLOSION_HUGE,
                    relativeBlock,
                    "explode",
                    1,
                    1
            );

            Logger.debug("Item in " + player.getDisplayName() + "'s hand is a: " + player.getInventory().getItemInMainHand().getType().toString());
            // TODO: Make option for timed usage, instead of one time usage.
            player.getInventory().getItemInMainHand().setAmount(0);

        }));
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
