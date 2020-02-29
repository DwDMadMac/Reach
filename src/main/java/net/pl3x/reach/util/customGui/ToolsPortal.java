package net.pl3x.reach.util.customGui;

import net.pl3x.reach.Main;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.CustomTools;
import net.pl3x.reach.util.guiFx.GuiControl;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToolsPortal {
    private static Main plugin;
    private static GuiControl reachToolsPortal;
    private static List<String> invItemLore;
    private static int invItemSlot;
    private static ItemStack invItemType;
    private static String invItemName;

    /**
     * Initialize the plugin object
     *
     * @param plugin Get plugin
     */
    public ToolsPortal(Main plugin) {
        this.plugin = plugin;
    }

    /**
     * Creates the custom tools portal with the custom options enums
     *
     * @param target Get player
     * @param portalItems Get custom tools portal items
     */
    public static void createToolsPortal(Player target, CustomTools[] portalItems) {
        //reachToolsPortal = new GuiControl(9,"Tools Portal", guiEvent -> { } , plugin);
        reachToolsPortal = new GuiControl(9,"Tools Portal", plugin);

        for (CustomTools customTools : portalItems) {
            switch (customTools) {
                case TREE_SPAWNER:
                    invItemSlot = Config.TREE_SPAWNER_SLOT;
                    invItemType = new ItemStack(Objects.requireNonNull(Material.getMaterial(Config.TREE_SPAWNER_TYPE.toUpperCase())));
                    invItemName = Lang.colorize(Config.TREE_SPAWNER_TITLE);
                    invItemLore = new ArrayList<>();
                    invItemLore.add(Lang.colorize(Config.TREE_SPAWNER_LORE));
                    reachToolsPortal.setItemStack(invItemSlot, invItemType, invItemName, invItemLore);
                default:
                    invItemSlot = Config.CLOSE_INVENTORY_SLOT;
                    invItemType = new ItemStack(Objects.requireNonNull(Material.getMaterial(Config.CLOSE_INVENTORY_TYPE)));
                    invItemName = Lang.colorize(Config.CLOSE_INVENTORY_TITLE);
                    invItemLore = new ArrayList<>();
                    invItemLore.add(Lang.colorize(Config.CLOSE_INVENTORY_LORE));
                    reachToolsPortal.setItemStack(invItemSlot, invItemType, invItemName, invItemLore);
                    break;
            }
        }
        reachToolsPortal.openInventory(target);
    }
}
