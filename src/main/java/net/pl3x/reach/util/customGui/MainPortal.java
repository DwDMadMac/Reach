package net.pl3x.reach.util.customGui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import net.pl3x.reach.Main;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.CustomOptions;
import net.pl3x.reach.util.CustomTools;
import net.pl3x.reach.util.Logger;
import net.pl3x.reach.util.guiFx.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static net.pl3x.reach.util.customGui.ToolsPortal.createToolsPortal;

public class MainPortal {
    private static Main plugin;
    private static GuiControl reachMainPortal;
    private static List<String> invItemLore;
    private static int invItemSlot;
    private static ItemStack invItemType;
    private static String invItemName;

    /**
     * Initialize the plugin object
     *
     * @param plugin Get plugin
     */
    public MainPortal(Main plugin) {
        MainPortal.plugin = plugin;
    }

    /**
     * Creates the main custom portal with the custom options enums
     *
     * @param target Get player
     * @param portalItems Get custom portal items
     */
    public static void createMainPortal(Player target, CustomOptions[] portalItems){
        reachMainPortal = new GuiControl(9, Config.MAIN_PORTAL_TITLE, plugin);
        //reachMainPortal = new GuiControl(target,9,Config.MAIN_PORTAL_TITLE, plugin);

        // TODO: Use polymorphism to fix the switch case issue
        for (CustomOptions customOptions : portalItems){
            switch (customOptions){
                case CUSTOM_TOOLS:
                    invItemSlot = Config.TOOLS_PORTAL_SLOT;
                    invItemType = new ItemStack(Objects.requireNonNull(Material.getMaterial(Config.TOOLS_PORTAL_TYPE)));
                    invItemName = Lang.colorize(Config.TOOLS_PORTAL_TITLE);
                    invItemLore = new ArrayList<>();
                    invItemLore.add(Lang.colorize(Config.TOOLS_PORTAL_LORE));
                    reachMainPortal.setItemStack(invItemSlot,invItemType,invItemName,invItemLore);
                case CUSTOM_WEAPONS:
                default:
                    invItemSlot = Config.CLOSE_INVENTORY_SLOT;
                    invItemType = new ItemStack(Objects.requireNonNull(Material.getMaterial(Config.CLOSE_INVENTORY_TYPE)));
                    invItemName = Lang.colorize(Config.CLOSE_INVENTORY_TITLE);
                    invItemLore = new ArrayList<>();
                    invItemLore.add(Lang.colorize(Config.CLOSE_INVENTORY_LORE));
                    reachMainPortal.setItemStack(invItemSlot, invItemType, invItemName, invItemLore);
                    break;
            }
        }
        reachMainPortal.openInventory(target);
    }
}
