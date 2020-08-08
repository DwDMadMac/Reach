package net.ezenity.reach.util.guiFx.providers;

import com.destroystokyo.paper.block.TargetBlockInfo;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
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
//            player.getInventory().getItemInMainHand().setAmount(0);

            ParticleSpawnedTask.setParticleTask(
                    player,
//                    Particle.FLASH,
                    Particle.FLAME,
                    "heart",
                    1,
                    5
            );

            // TODO: Apply spawning particle effects
        }));
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
