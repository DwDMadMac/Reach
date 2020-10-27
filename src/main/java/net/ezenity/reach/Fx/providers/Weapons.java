package net.ezenity.reach.Fx.providers;

import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.ezenity.reach.Fx.Portals;
import net.ezenity.reach.util.build.Spawn;
import org.bukkit.entity.Player;
/**
 * Weapons Provider.
 *
 * This provider is the class for implementing weapon inventory items. Here
 * will also contain information to what will happen next when a user clicks on
 * one of the weapon items.
 *
 * @author Ezenity
 * @version 1.2.0
 * @since 0.0.1
 */
public class Weapons extends Portals implements InventoryProvider {
    /**
     * Spawned Item. Generates an ItemStack that is set within the configuration file.
     * This is used for setting the weapons inside the Weapons Portal.
     */
    private final Spawn spawnItem = new Spawn();

    /**
     * Weapons Portal.
     *
     * This is the custom inventory for the Weapons Portal. When a user selects a specific weapon
     * it will then be placed in the players hand for further evaluation on the given tools
     * characteristics.
     *
     * @param player get the player that is interacting with the custom portal.
     * @param inventoryContents set the weapons inside the Weapons Portal.
     */
    @Override
    public void init(Player player, InventoryContents inventoryContents) {

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
