package net.pl3x.reach.util.guiFx;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiControl {
    private Player target;
    private int inventorySlots;
    private String inventoryName;
    private GuiHandler guiHandle;
    private String[] itemStackName;
    private ItemStack[] itemStacks;

    /**
     * Constructor for initializing the class objects
     *
     * @param target Initialize player interacting with inventory
     * @param inventorySlot Initialize inventory slot amount
     * @param inventoryName Initialize inventory custom name
     * //@param inventoryClosed Initialize if inventory was closed or not
     * //@param itemStack Initialize item inside inventory
     */
    public GuiControl(Player target, int inventorySlot, String inventoryName, GuiHandler guiHandler) {
        this.target = target;
        this.inventorySlots = inventorySlot;
        this.inventoryName = inventoryName;
        this.guiHandle = guiHandler;
        this.itemStackName = new String[inventorySlot];
        this.itemStacks = new ItemStack[inventorySlot];
    }

    /**
     * This method gets the custom item stack and sets it and the custom data to the given slot location
     *
     * @param invSlot Set custom item stack to inventory slot
     * @param itemStackType Set custom item stack
     * @param itemStackNameSet Set custom item stack name
     * @param itemStackLoreSet Set custom item stack lore
     * @return Return custom item stack and it data
     */
    public GuiControl setItemStack(int invSlot, ItemStack itemStackType, String itemStackNameSet, List<String> itemStackLoreSet){
        itemStackName[invSlot] = itemStackNameSet;
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
}
