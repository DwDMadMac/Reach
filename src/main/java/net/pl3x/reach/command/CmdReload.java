package net.pl3x.reach.command;

import java.util.Collections;
import java.util.List;
import net.pl3x.reach.Main;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.Logger;
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
 */
public class CmdReload implements TabExecutor {
    private Main plugin;

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
     * @return Return true if plugin was reloaded
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("command.reach.reload")){
            Lang.send(sender, Lang.COMMAND_NO_PERMISSION);
            return true;
        }

        // TODO: Fix NPE fo msg
        String msg = plugin.getName() + " v" + plugin.getDescription().getVersion();

        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            Config.reload();
            Lang.reload();
            msg += " reload";
            Logger.info(plugin.getName() + " v" + plugin.getDescription().getVersion() + " was reloaded by " + sender.getName());
        }

        Lang.send(sender, msg);

        return true;
    }
}
