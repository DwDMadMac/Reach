package net.pl3x.reach.util.guiFx;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiItem extends GuiEvent {
    private ItemStack itemStack;
    private String itemName;
    private int modelData;
    private List<String> itemLore;

    public GuiItem(Player target, int inventorySlot, String inventoryName, ItemStack itemStack) {
        super(target, inventorySlot, inventoryName, itemStack);
    }

    /**
     * This method will get the item stack
     *
     * @return Return item stack
     */
    public ItemStack getItemStack() {
        return itemStack;
    }

    /**
     * This method will set the item stack
     *
     * @param itemStack Set item stack
     */
    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    /**
     * This method will get the name of the item stack
     *
     * @return Return item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method will set the name of the item stack
     *
     * @param itemName Set item name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * This method will get the custom model data of the given item stack
     *
     * @return Return custom model data
     */
    public int getModelData() {
        return modelData;
    }

    /**
     * This method will set a custom model data to an item stack
     *
     * @param modelData Set custom model data
     */
    public void setModelData(int modelData) {
        this.modelData = modelData;
    }

    /**
     * This method will get the item stack lore
     * <p>
     * The item stack lore is created as a list and is set to the
     * item stack item meta
     *
     * @return Return item lore
     */
    public List<String> getItemLore() {
        return itemLore;
    }

    /**
     * This method will set the item stack lore
     * <p>
     * The item stack lore is set to the item stack item meta
     *
     * @param itemLore Set item stack lore
     */
    public void setItemLore(List<String> itemLore) {
        this.itemLore = itemLore;
    }
}
