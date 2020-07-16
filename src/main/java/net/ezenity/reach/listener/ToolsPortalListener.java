package net.ezenity.reach.listener;

public class ToolsPortalListener {}

//public class ToolsPortalListener implements Listener {
//    private Main plugin = Main.getInstance();
//    private String invName = Config.TOOLS_PORTAL_TITLE;
//    private Player target;
//
//    /**
//     * Initialize the plugin field
//     *
//     * @param plugin Get plugin
//     */
//    public ToolsPortalListener(Main plugin) {
//        this.plugin = plugin;
//    }
//
//    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
//    public void onToolsPortalClick(InventoryClickEvent inventoryClickEvent){
//        String clickedInvTitle = inventoryClickEvent.getWhoClicked().getOpenInventory().getTitle();
//
//        if (!clickedInvTitle.equalsIgnoreCase(invName)){
//            Logger.debug("onToolsPortalClick | Not tools portal inventory, return.");
//            return;
//        }
//
//        // Stop all clickable events
//        inventoryClickEvent.setCancelled(true);
//        Logger.debug("onToolsPortalClick | All clickable events are canceled for tools portal.");
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
//            // TODO: create lang for message
//            Lang.send(target, "Closing inventory");
//        }
//
//        // Run checks if Tree Spawner tool is selected
//        if (itemClicked.getType().equals(Material.WOODEN_AXE)){
//            // Check if the tree Spawner tool is enabled
//            if (!Config.TREE_SPAWNER_ENABLED){
//                Logger.debug("onToolsPortalClick | " + target.getDisplayName() + " clicked Tree Spawner tool, however it is disabled. Closing inventory");
//                target.closeInventory();
//                // TODO: Create lang for message
//                Lang.send(target, "Sorry, the Tree Spawner tool is disabled.");
//                return;
//            }
//
//            // Check if target has permissions
//            if (!target.hasPermission("command.reach.portal.tools.treeSpawner")){
//                Logger.debug("onToolsPortalClick | " + target.getDisplayName() + " Does not have permission to use the Tree Spawner Tool. Return");
//                // TODO Create lang for message
//                Lang.send(target, "You do not have permission to use the Tree Spawner Tool.");
//                return;
//            }
//
//            // Check to see if the target main hand is empty
//            if (!target.getInventory().getItemInMainHand().getType().isEmpty()){
//                Logger.debug("onToolsPortalClick | " + target.getDisplayName() + " main hand is not empty, cannot place tool in hand. Return.");
//                // TODO: Create lang for message
//                Lang.send(target, "Your hand is not empty, tool cannot be placed. Cancelling. Please empty main hand and try again.");
//                target.closeInventory();
//                return;
//            }
//
//            // Give player tree spawner tool
//            // TODO: Create class/method for spawning in tools
//            target.closeInventory();
//
//            // TODO: Create particles effects
//            // TODO: Create cool down for tool
//        }
//
//    }
//}
