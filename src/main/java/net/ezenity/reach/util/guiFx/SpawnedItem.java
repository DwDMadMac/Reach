package net.ezenity.reach.util.guiFx;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

/**
 * This class will be a source for getting the given item located in the config file as well
 * as setting an item to a players main hand.
 */
public class SpawnedItem extends CreateItem {
    private String itemString;

    /**
     * Sets the item to the given players main hand.
     *
     * @param player get given player
     * @param itemString locate item name from config file
     * @param itemIdentifier unique number identifier for set item.
     */
    @Override
    public void setItem(Player player, String itemString, int itemIdentifier) {
        this.itemString = itemString;
        ItemMeta itemMeta = getItem().getItemMeta();
        Objects.requireNonNull(itemMeta).setCustomModelData(itemIdentifier);
        getItem().setItemMeta(itemMeta);
        player.getInventory().setItemInMainHand(getItem());
    }

    /**
     * Get the custom itemstack with the given item string located in the
     * {@link net.ezenity.reach.configuration.Config} class.
     *
     * @return custom item stack
     */
    private ItemStack getItem() {
        return getItem(itemString);
    }
}
