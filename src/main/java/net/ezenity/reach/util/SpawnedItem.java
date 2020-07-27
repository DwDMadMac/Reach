package net.ezenity.reach.util;

import net.ezenity.reach.Main;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.util.guiFx.CustomItemStack;
import org.apache.commons.lang.Validate;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpawnedItem implements CustomItemStack {
    private final Main plugin = Main.getInstance();
    private final String itemString;
    private final int itemIdentifier;

    private final Enchantment enchantment;
    private int enchantLevel;
    private boolean levelRestrict;

    private final ItemFlag itemFlag;

    public SpawnedItem(Player player,
                       String itemString,
                       int itemIdentifier,
                       Enchantment enchantment, int enchantLevel, boolean levelRestrict,
                       ItemFlag itemFlag
    ) {
        Validate.notNull(itemString, "Item String cannot be null.");
        Validate.notNull(enchantment, "There must be a qualifying enchantment input.");
        this.itemString = itemString;
        this.itemIdentifier = itemIdentifier;
        this.enchantment = enchantment;
        this.enchantLevel = enchantLevel;
        this.levelRestrict = levelRestrict;
        this.itemFlag = itemFlag;

        setItem(player);
    }

    public SpawnedItem(Player player,
                       String itemString,
                       int itemIdentifier,
                       Enchantment enchantment, int enchantLevel, boolean levelRestrict
    ) {
        Validate.notNull(itemString, "Item String cannot be null.");
        Validate.notNull(enchantment, "There must be a qualifying enchantment input.");
        this.itemString = itemString;
        this.itemIdentifier = itemIdentifier;

        this.enchantment = enchantment;
        this.enchantLevel = enchantLevel;
        this.levelRestrict = levelRestrict;

        this.itemFlag = ItemFlag.HIDE_ATTRIBUTES;

        setItem(player);
    }

    public SpawnedItem(Player player, String itemString, int itemIdentifier) {
        Validate.notNull(itemString, "Item String cannot be null.");
        this.itemString = itemString;
        this.itemIdentifier = itemIdentifier;
        this.enchantment = null;
        this.itemFlag = ItemFlag.HIDE_ATTRIBUTES;

        setItem(player);
    }

    private void setItem(Player player) {
        player.getInventory().setItemInMainHand(getItem(itemString));
    }

    @Override
    public ItemStack getItem(String itemString) {
        String itemType = (String) plugin.getConfig().get("portal." + itemString + ".spawned.type");
        ItemStack itemStack = new ItemStack(Objects.requireNonNull(Material.getMaterial(Objects.requireNonNull(itemType))));
        ItemMeta itemMeta = itemStack.getItemMeta();
        Objects.requireNonNull(itemMeta).setDisplayName(Lang.colorize(plugin.getConfig().getString("portal." + itemString + ".spawned.title")));
        itemMeta.setCustomModelData(itemIdentifier);
        if (this.enchantment != null)
            itemMeta.addEnchant(enchantment, enchantLevel, levelRestrict); // TODO: Make method for multiple enchantment usages
        if (this.itemFlag != null)
            itemMeta.addItemFlags(itemFlag);// TODO: Make method to loop through for multiple Item Flag additions
//        if (this.)
//            itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR, ); // TODO: Make method for a system of player buffs & debuffs (check Wiki)
        List<String> itemLore = new ArrayList<>();
        for (String newLines : plugin.getConfig().getStringList("portal." + itemString + ".spawned.lore")) {
            itemLore.add(ChatColor.translateAlternateColorCodes('&', newLines));
        }
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

}
