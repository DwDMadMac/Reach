package net.pl3x.reach.util.guiFx;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * This is the base class which will handles all the
 * Graphical User Interfaces events for custom inventories
 */
public class GuiEvent {
    private Player target;
    private int inventorySlot;
    private String inventoryName;
    private boolean inventoryClose;
    private boolean inventoryDestroy;
    private ItemStack itemStack;

    public GuiEvent(Player target, int inventorySlot, String inventoryName, ItemStack itemStack) {
        this.target = target;
        this.inventorySlot = inventorySlot;
        this.inventoryName = inventoryName;
        this.inventoryClose = true;
        this.inventoryDestroy = false;
        this.itemStack = itemStack;
    }

    /**
     * Get the player interacting with custom inventory
     *
     * @return Return player
     */
    public Player getTarget() {
        return target;
    }

    /**
     * Get the custom inventory slot amount
     *
     * @return Return slot amount
     */
    public int getInventorySlot() {
        return inventorySlot;
    }

    /**
     * Get the custom inventory name
     *
     * @return Return inventory name
     */
    public String getInventoryName() {
        return inventoryName;
    }

    /**
     * Get the item stack that is inside the custom inventory
     *
     * @return Return item stack
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * Check if the custom inventory is closed or not
     * <p>
     * Will return or true value if the custom inventory was closed
     *
     * @return Return true or false depending on inventory state
     */
    public boolean isInventoryClose() {
        return inventoryClose;
    }

    /**
     * Check if all events are unregistered to plugin
     *
     * @return Return true if events are unregistered
     */
    public boolean isInventoryDestroy() {
        return inventoryDestroy;
    }

    /**
     * Set the custom inventory state to true or false
     * <p>
     * Setting the value to true will state that the custom
     * inventory is closed and setting the value to false will
     * state that the custom inventory is not closed
     *
     * @param inventoryClosed Set true to close inventory
     */
    public void setInventoryClosed(boolean inventoryClosed) {
        this.inventoryClose = inventoryClosed;
    }

    /**
     * Set destroy state to true or false
     * <p>
     * Setting this value to true will unregister
     * all the events for this custom inventory
     *
     * @param inventoryDestroy Set true to unregister events
     */
    public void setInventoryDestroy(boolean inventoryDestroy) {
        this.inventoryDestroy = inventoryDestroy;
    }
}
