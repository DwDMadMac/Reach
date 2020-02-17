package net.pl3x.reach.util.customGui;

import java.util.List;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.guiFx.GuiControl;
import net.pl3x.reach.util.guiFx.GuiEvent;
import net.pl3x.reach.util.guiFx.GuiHandler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MainPortal  {
    private GuiEvent guiControl;
    private Player target;
    private static List<String> itemStackLore;

    public static void createMainPortal(Player target){

        GuiControl test = new GuiControl(target,36,"Main Reach Portal", mainPortal ->{
            if (mainPortal.isInventoryClosed()){
                mainPortal.getTarget().closeInventory();
            }
        });

        // TODO: FIX NPE for item stack lore
        itemStackLore.add("&7Click to close the");
        itemStackLore.add("&7Main Reach Portal");
        test.setItemStack(
                0,
                new ItemStack(Material.APPLE),
                Lang.colorize("&4Close Inventory"),
                itemStackLore);
    }
}
