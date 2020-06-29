package net.pl3x.reach.util.guiFx;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.pl3x.reach.Main;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.Logger;
import net.pl3x.reach.util.particleFx.Particles;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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
            // Check if target has permissions
            if (!player.hasPermission("command.reach.portal.tools.treeSpawner")) {
                Logger.debug("onToolsPortalClick | " + player.getDisplayName() + " Does not have permission to use the Tree Spawner Tool. Return");
                // TODO Create lang for message
                Lang.send(player, Lang.COMMAND_NO_PERMISSION
                        .replace("{getCommand}", "Tree Spawner"));
                return;
            }

            // Check if the tree Spawner tool is enabled
            if (!Config.TREE_SPAWNER_ENABLED) {
                Logger.debug("onToolsPortalClick | " + player.getDisplayName() + " clicked Tree Spawner tool, however it is disabled. Closing inventory");
                Logger.info(player.getDisplayName() + "&2 clicked Tree Spawner when it was disabled, closed inventory.");
                player.closeInventory();
                Lang.send(player, Lang.DISABLED_COMMAND
                        .replace("{getDisabledCommand}", "Tree Spawner"));
                return;
            }

            // TODO: Create class/method for spawning in tools
            // TODO: Create particles effects
            Particles forceFieldParticle = new Particles(player, Particle.DOLPHIN, "sphere");
//            final Runnable spawnParticle = () -> forceFieldParticle.run();
//            final ScheduledFuture<?> particleHandler = scheduler.scheduleAtFixedRate(spawnParticle, 0, 100, TimeUnit.MILLISECONDS);

            final ScheduledFuture<?> particleHandler = scheduler.scheduleAtFixedRate(forceFieldParticle, 0, 100, TimeUnit.MILLISECONDS);
            scheduler.schedule(() -> {
                particleHandler.cancel(true);
            }, 200, TimeUnit.SECONDS); // TODO: Add config for seconds particle is spawned for
            taskRunning = true;

            if (particleHandler.isCancelled()){
                taskRunning = false;
            }
            // TODO: Create cool down for tool
        } ));

        // TODO: Make Flower Spawner inventory contents
    }
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private boolean taskRunning;

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
