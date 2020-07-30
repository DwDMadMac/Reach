package net.ezenity.reach.util.guiFx;

import org.bukkit.entity.Player;

/**
 * This class will be a source for getting the given item located in the config file as well
 * as setting an item to a players main hand.
 */
public class SpawnedItem extends CreateItem {

    /**
     * Sets the item to the given players main hand.
     *
     * @param player get given player
     * @param itemString locate item name from config file
     * @param itemIdentifier unique number identifier for set item.
     */
    @Override
    public void setItem(Player player, String itemString, int itemIdentifier) {
        player.getInventory().setItemInMainHand(getItem(itemString));
    }
}
