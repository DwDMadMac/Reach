package net.pl3x.reach.util.guiFx;

import java.util.List;

import net.pl3x.reach.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class GuiControl implements Listener {
    private GuiEvent guiEvent;
    private Player target;
    private Plugin plugin;
    private int inventorySlots;
    private String inventoryName;
    private GuiHandler guiHandle;
    private String[] itemStackNames;
    private ItemStack[] itemStacks;

    /**
     * Constructor for initializing the class objects
     *
     *
     * @param inventorySlots Initialize inventory slot amount
     * @param inventoryName Initialize inventory custom name
     * //@param inventoryClosed Initialize if inventory was closed or not
     * //@param itemStack Initialize item inside inventory
     */
    //public GuiControl(int inventorySlots, String inventoryName, GuiHandler guiHandler, Plugin plugin) {
    //public GuiControl(Player target, int inventorySlots, String inventoryName, Plugin plugin) {
    public GuiControl(int inventorySlots, String inventoryName, Plugin plugin) {
        //this.target = target;
        this.inventorySlots = inventorySlots;
        this.inventoryName = inventoryName;
        //this.guiHandle = guiHandler;
        this.plugin = plugin;
        this.itemStackNames = new String[inventorySlots];
        this.itemStacks = new ItemStack[inventorySlots];
        assert false;
        //plugin.getServer().getPluginManager().registerEvents((Listener) guiEvent, plugin);
    }

    /**
     * This method gets the custom item stack and sets it, and the custom data to the given slot location
     *
     * @param invSlot Set custom item stack to inventory slot
     * @param itemStackType Set custom item stack
     * @param itemStackNameSet Set custom item stack name
     * @param itemStackLoreSet Set custom item stack lore
     * @return Return custom item stack and it data
     */
    public GuiControl setItemStack(int invSlot, ItemStack itemStackType, String itemStackNameSet, List<String> itemStackLoreSet){
        itemStackNames[invSlot] = itemStackNameSet;
        itemStacks[invSlot] = setItem(itemStackType, itemStackNameSet, itemStackLoreSet);
        return this;
    }

    /**
     * This method will set all the necessary data to the custom item stack
     *
     * @param itemStackSetter Set the custom item stack
     * @param itemStackNameSetter Set the custom item stack name
     * @param itemStackLoreSetter Set the custom item stack lore
     * @return Return custom item stack
     */
    private ItemStack setItem(ItemStack itemStackSetter, String itemStackNameSetter, List<String> itemStackLoreSetter){
        ItemMeta itemStackMeta = itemStackSetter.getItemMeta();
        itemStackMeta.setDisplayName(itemStackNameSetter);
        itemStackMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemStackMeta.setLore(itemStackLoreSetter);
        itemStackSetter.setItemMeta(itemStackMeta);
        return itemStackSetter;
    }

    /**
     * Open the custom inventory
     * <p>
     * This method will open the custom inventory with all the given
     * custom item stacks
     *
     * @param target Get the player who is interacting with inventory
     */
    public void openInventory(Player target){
        Inventory inventory = Bukkit.createInventory(target, inventorySlots, inventoryName);
        // Input the item stack into slot
        for (int i = 0; i < itemStacks.length; i++){
            if (itemStacks[i] != null){
                inventory.setItem(i, itemStacks[i]);
            }
        }
        // Open the custom inventory with custom item stacks
        target.openInventory(inventory);
    }

    public void destroy() {
        HandlerList.unregisterAll(this);
        guiHandle = null;
        plugin = null;
        itemStackNames = null;
        itemStacks = null;
    }
}
