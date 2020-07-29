package net.ezenity.reach.util.guiFx;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Abstract class used for creating a get item method using a string. To see how this can be utilized
 * refer to {@link PortalItem}.
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
    public abstract ItemStack getItem(String itemString);

    /**
     * Sets the item to the given players main hand.
     *
     * @param player get given player
     * @param itemString locate item name from config file
     * @param itemIdentifier unique number identifier for set item.
     */
    public abstract void setItem(Player player, String itemString, int itemIdentifier);
}
