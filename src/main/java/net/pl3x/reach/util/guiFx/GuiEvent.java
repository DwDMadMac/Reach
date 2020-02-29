package net.pl3x.reach.util.guiFx;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

/**
 * This is the base class which will handles all the
 * Graphical User Interfaces events for custom inventories
 */
public class GuiEvent {
    private Player target;
    private int inventorySlot;
    private String inventoryName;
    private boolean inventoryClosed;
    private ItemStack itemStack;
    private InventoryClickEvent inventoryClickEvent;


    //private Player target;
    private Plugin plugin;
    private int inventorySlots;
    //private String inventoryName;
    private GuiHandler guiHandle;
    private String[] itemStackName;
    private ItemStack[] itemStacks;


    /**
     * Check for inventory click events
     *
     * @return Return inventory clicks
     */
    public InventoryClickEvent getInventoryClickEvent() {
        return inventoryClickEvent;
    }

    /**
     * This method will make inventory click event true or false
     *
     * @param inventoryClickEvent Set inventory click event
     */
    public void setInventoryClickEvent(InventoryClickEvent inventoryClickEvent) {
        this.inventoryClickEvent = inventoryClickEvent;
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
     * Set the player using the custom inventory
     *
     * @param target Set player
     */
    public void setTarget(Player target) {
        this.target = target;
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
     * Set the custom inventory slot amount
     *
     * @param inventorySlot Set slot amount
     */
    public void setInventorySlot(int inventorySlot) {
        this.inventorySlot = inventorySlot;
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
     * Set the custom inventory name
     *
     * @param inventoryName Set inventory name
     */
    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    /**
     * Check if the custom inventory is closed or not
     * <p>
     * Will return or true value if the custom inventory was closed
     *
     * @return Return true or false depending on inventory state
     */
    public boolean isInventoryClosed() {
        return inventoryClosed;
    }

    /**
     * Set the custom inventory state to true or false
     * <p>
     * Setting the value to true will state that the custom
     * inventory is closed and setting the value to false will
     * state that the custom inventory is not closed
     *
     * @param inventoryClosed Set true or false to close inventory
     */
    public void setInventoryClosed(boolean inventoryClosed) {
        this.inventoryClosed = inventoryClosed;
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
     * Set the item stack inside the custom inventory
     *
     * @param itemStack Set item stack
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
