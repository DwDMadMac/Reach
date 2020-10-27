package net.ezenity.reach.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.ezenity.reach.Main;
import net.ezenity.reach.Fx.Portals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

/**
 * Main Reach Portal. This will hold the starting point to child portals.
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 0.0.1
 */
public class CmdGui implements TabExecutor {
    /**
     * Portals Array List. This list is used for auto tab fill.
     */
    private final List<String> portals = Arrays.asList("main", "tools", "weapons");

    /**
     * Will auto populate the main gui options in the text box to allow the user to tab in the remainder of the option
     *
     * @param sender Get sender
     * @param command Get command object info
     * @param label get typed input from sender
     * @param args Get arguments after inputted command
     * @return Return command options
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && sender.hasPermission("command.reach.portals"))
            return new ArrayList<>(portals);
//            return portals.stream().collect(Collectors.toList());

        return Collections.emptyList();
    }

    /**
     * Main Gui Command (Main Portal)
     * <p>
     * Will load the main gui for the Reach plugin
     * <p>
     * This will hold all the features available for players to select from.
     * Once a player clicks an item inside the Reach Portal (gui), depending on
     * the feature, a new portal (custom inventory) will appear, or an item will be placed inside
     * their inventory for usage
     *
     * @param sender Get sender
     * @param command Get command object info
     * @param label get typed input from sender
     * @param args Get arguments after inputted command
     * @return Return true if plugin was reloaded
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if send is a player
        if (!(sender instanceof Player)){
            Main.getReachLang().send(sender, Main.getReachLang().PLAYER_COMMAND);
            return true;
        }

        // Make sender player
        Player target = (Player) sender;

        // Check if player has proper permission
        if (!target.hasPermission("command.reach.portals")){
            Main.getReachLang().send(target, Main.getReachLang().COMMAND_NO_PERMISSION
            .replace("{getCommand}", "Portal"));
            return true;
        }

        // Check to see if the target main hand is empty
        if (!target.getInventory().getItemInMainHand().getType().isAir()){
            Main.getReachLogger().debug("onToolsPortalClick | " + target.getDisplayName() + " main hand is not empty, cannot place tool in hand. Return.");
            Main.getReachLang().send(target, "Your hand is not empty, tool cannot be placed. Cancelling. Please empty main hand and try again."); // TODO: Create lang for message
            target.closeInventory();
            return true;
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("main"))
                Portals.MAIN_INVENTORY.open(target);
            else if (args[0].equalsIgnoreCase("tools"))
                Portals.TOOLS_INVENTORY.open(target);
            else if (args[0].equalsIgnoreCase("weapons"))
                Portals.WEAPONS_INVENTORY.open(target);
        }

        return true;
    }
}
