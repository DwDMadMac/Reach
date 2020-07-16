package net.ezenity.reach.listener;

public class MainPortalListener {}

//public class MainPortalListener implements Listener {
//    private Main plugin;
//    private Player target;
//    private String invName = Config.MAIN_PORTAL_TITLE;
//
//    /**
//     * Initialize the plugin field
//     *
//     * @param plugin Get plugin
//     */
//    public MainPortalListener(Main plugin) {
//        this.plugin = plugin;
//    }
//
//    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
//    public void onMainPortalClick(InventoryClickEvent inventoryClickEvent){
//        String clickedInvTitle = inventoryClickEvent.getWhoClicked().getOpenInventory().getTitle();
//
//        if (!clickedInvTitle.equalsIgnoreCase(invName)){
//            Logger.debug("onMainPortalClick | Not main portal inventory, return.");
//            return;
//        }
//
//        // Stop all clickable events
//        inventoryClickEvent.setCancelled(true);
//        Logger.debug("onMainPortalClick | All clickable events are canceled for Main Reach Portal.");
//
//        target = (Player) inventoryClickEvent.getWhoClicked();
//
//        // Get clicked item
//        ItemStack itemClicked = inventoryClickEvent.getCurrentItem();
//
//        // Close inventory if ItemStack APPLE is clicked
//        if (itemClicked.getType().equals(Material.APPLE)){
//            target.closeInventory();
//
//            Logger.debug("onMainPortalClick | Target clicked Apple, closing inventory.");
//            Lang.send(target, "Closing inventory");
//        }
//
//        // Close Main Reach Portal and open Tools Portal
////        if (itemClicked.getType().equals(Material.DIAMOND_AXE)){
////            target.closeInventory();
////
////            CustomTools[] portalItems = {CustomTools.TREE_SPAWNER};
////            createToolsPortal(target, portalItems);
////        }
//
//
//    }
//}
