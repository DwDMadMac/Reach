package net.ezenity.reach.util.guiFx;

import fr.minuskube.inv.content.InventoryContents;
import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.Main;
import net.ezenity.reach.configuration.Lang;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class PortalItem extends CustomItemStack {
    private Main plugin = Main.getInstance();
    private boolean slotRow;
    private boolean slotCol;

    /**
     * Get a custom item from the configuration file. Just add in the item name exactly how it is
     * inside the config.yml {@link Config} without the suffix declaration,
     * when calling the getItem() method. Usage can be viewed
     * {@link MainProvider#init(Player, InventoryContents)}
     * <p>
     * Suffix Declarations:
     * <ul>
     *    <li>enabled</li>
     *    <li>type</li>
     *    <li>title</li>
     *    <li>lore</li>
     * </ul>
     *
     * @param itemString Gets a string. Can use this to get a String from a config file.
     * @return custom tool with prerequisites from the config file
     */
    @Override
    public ItemStack getItem(String itemString) {
        String itemType = (String) plugin.getConfig().get("portal." + itemString + "-type");
        ItemStack itemStack = new ItemStack(Objects.requireNonNull(Material.getMaterial(Objects.requireNonNull(itemType))));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setDisplayName(Lang.colorize(plugin.getConfig().getString("portal." + itemString + "-title")));
        List<String> itemLore = new ArrayList<>();
        for (String newLines : plugin.getConfig().getStringList("portal." + itemString + "-lore")) {
            itemLore.add(ChatColor.translateAlternateColorCodes('&', newLines));
        }
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
