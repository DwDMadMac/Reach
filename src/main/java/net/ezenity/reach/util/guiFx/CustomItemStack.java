package net.ezenity.reach.util.guiFx;

import org.bukkit.inventory.ItemStack;

/**
 * Abstract class used for creating a get item method using a string. To see how this can be utilized
 * refer to {@link PortalItem}.
 */
public interface CustomItemStack {
    /**
     * Gets the given custom itemstack. Since we do not know what the given itemstack
     * will contain this will be implemented as a polymorphism from this object
     * class.
     *
     * @param itemString Gets a string. Can use this to get a String from a config file.
     * @return itemstack
     */
    ItemStack getItem(String itemString);
}
