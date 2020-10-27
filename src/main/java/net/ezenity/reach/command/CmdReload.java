package net.ezenity.reach.command;

import java.util.Collections;
import java.util.List;

import net.ezenity.reach.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

/**
 * Reach Reload Class
 * <p>
 * This will allow you to reload the following classes:
 * <ul>
 *     <li>Config</li>
 *     <li>Lang</li>
 * </ul>
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 0.0.1
 */
public class CmdReload implements TabExecutor {

    /**
     * Will auto populate the reload option in the text box to allow the user to tab in the remainder of the option
     *
     * @param sender Get sender
     * @param command Get command object info
     * @param label get typed input from sender
     * @param args Get arguments after inputted command
     * @return Return command options
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if ( args.length == 1 && "reload".startsWith(args[0].toLowerCase()) && sender.hasPermission("command.reach.reload") ) {
            return Collections.singletonList("reload");
        }

        return Collections.emptyList();
    }

    /**
     * Reload Command
     *
     * Will reload the Reach plugin
     *
     * @param sender Get sender
     * @param command Get command object info
     * @param label get typed input from sender
     * @param args Get arguments after inputted command
     * @return Return true if the plugin was reloaded
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("command.reach.reload")){
            Main.getReachLang().send(sender, Main.getReachLang().COMMAND_NO_PERMISSION
                .replace("{getCommand}", "Reload"));
            return true;
        }


        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            Main.getReachLang().reload();
            Main.getReachConfig().reload();
            Main.getReachLogger().info(Main.getInstance().getName() + " v" + Main.getInstance().getDescription().getVersion() + " was reloaded by " + sender.getName());
        }

        Main.getReachLang().send(sender, "Reach plugin reloaded"); // TODO: apply to lang

        return true;
    }
}
