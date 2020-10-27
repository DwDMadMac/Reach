package net.ezenity.reach.util.build;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

/**
 * This class will be a source for getting the given item located in the config file as well
 * as setting an item to a players main hand.
 *
 * @author Ezenity
 * @version 1.2.0
 * @since 1.0.0
 */
public class Spawn extends Make {
    /**
     * Item String. This is used to get the name of the item from the config file.
     */
    private String itemString;

    /**
     * Sets the item to the given players main hand.
     *
     * @param player get given player
     * @param itemString locate item name from config file
     * @param itemIdentifier unique number identifier for set item.
     */
    @Override
    public void set(Player player, String itemString, int itemIdentifier) {
        this.itemString = itemString;

        ItemStack newSetItem = get();
        ItemMeta itemMeta = newSetItem.getItemMeta();
        Objects.requireNonNull(itemMeta).setCustomModelData(itemIdentifier);
        newSetItem.setItemMeta(itemMeta);

        player.getInventory().setItemInMainHand(newSetItem);
    }

    /**
     * Get the custom itemstack with the given item string located in the
     * {@link net.ezenity.reach.configuration.Config} class.
     *
     * @return custom item stack
     */
    public ItemStack get() {
        return create(itemString);
    }
}
