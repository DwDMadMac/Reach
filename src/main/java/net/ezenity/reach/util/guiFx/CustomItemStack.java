package net.ezenity.reach.util.guiFx;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Abstract class used for creating a get item method using a string. To see how this can be utilized
 * refer to {@link CreateItem}.
 *
 * @author anthonymmacallister
 * @version 1.0.0
 */
public abstract class CustomItemStack {
    /**
     * Gets the given custom itemstack. Since we do not know what the given itemstack
     * will contain this will be implemented as a polymorphism from this object
     * class.
     *
     * @param itemString Gets a string. Can use this to get a String from a config file.
     * @return itemstack
     */
    public abstract ItemStack createItemStack(String itemString);

    /**
     * Sets the item to the given players main hand.
     *
     * @param player get given player
     * @param itemString locate item name from config file
     * @param itemIdentifier unique number identifier for set item.
     */
    public abstract void setItem(Player player, String itemString, int itemIdentifier);

    /**
     * Gets the status of the custom itemstack. This can be utilized for creating string values
     * based on their boolean value.
     *
     * @param configItemLocation Gets a string. can be used to get a boolean value from a config file.
     * @param trueString Gets the string value for a boolean value if true
     * @param falseString  Gets the string value for a boolean value if false
     * @return a string value.
     */
    public abstract String setConfigString(boolean configItemLocation, String trueString, String falseString);

    /**
     * Gets the boolean value from the applied configuration location inside the parameter.
     *
     * @param configItemLocation get the boolean from a config file
     * @return boolean value from config.
     */
    public abstract boolean getConfigBoolean(boolean configItemLocation);
}
