package net.pl3x.reach.listener;

import net.pl3x.reach.Main;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.util.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainPortalListener implements Listener {
    private Main plugin;
    private Player target;
    private String invName = Config.MAIN_PORTAL_TITLE;

    /**
     * Initialize the plugin field
     *
     * @param plugin Get plugin
     */
    public MainPortalListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onMainPortalClick(InventoryClickEvent inventoryClickEvent){
        String clickedInvTitle = inventoryClickEvent.getWhoClicked().getOpenInventory().getTitle();

        if (!clickedInvTitle.equalsIgnoreCase(invName)){
            Logger.debug("onMainPortalClick | Now main portal inventory, return.");
            return;
        }

        // Stop all clickable events
        inventoryClickEvent.setCancelled(true);
        Logger.debug("onMainPortalClick | All clickable events are canceled for Main Reach Portal.");

        target = (Player) inventoryClickEvent.getWhoClicked();


    }
}
