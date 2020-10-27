package net.ezenity.reach.util;

import net.ezenity.reach.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Reach Logger Class
 * <p>
 * Custom utilities for a console messages
 *
 * @author Ezenity
 * @version 0.0.1
 * @since 0.0.1
 */
public class Logger {
    /**
     * Logs plugin messages and sends to console with colors or not colors depending on configuration settings
     *
     * @param msg Send console message
     */
    public void log(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&a[&7Reach&a]&r " + msg);
        if (!Main.getReachConfig().COLOR_LOGS){
            msg = ChatColor.stripColor(msg);
        }
        Bukkit.getServer().getConsoleSender().sendMessage(msg);
    }

    /**
     * Debug Messages
     * <p>
     * Will only display messages when the debug mode is set to true in the configuration file
     *
     * @param msg Send debug message
     */
    public void debug(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&2[&eDEBUG&2]&f " + msg);
        if (Main.getReachConfig().DEBUG_MODE){
            if (!Main.getReachConfig().COLOR_LOGS){
                msg = ChatColor.stripColor(msg);
            }
            log(msg);
        }
    }

    /**
     * Info Messages
     * <p>
     * Will only display info messages if the Info Logging option is set to true in the configuration file
     *
     * @param msg
     */
    public void info(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&b[&7INFO&b]&f " + msg);
        if (Main.getReachConfig().INFO_LOGGING) {
            if (!Main.getReachConfig().COLOR_LOGS){
                msg = ChatColor.stripColor(msg);
            }
            log(msg);
        }
    }

    /**
     * Error Messages
     * <P>
     * Will only display warn messages if the warn logging option is set to true in the configuration file
     *
     * @param msg
     */
    public void warn(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&6[&eWARN&6]&a " + msg);
        if (Main.getReachConfig().WARN_LOGGING){
            if (!Main.getReachConfig().COLOR_LOGS){
                msg = ChatColor.stripColor(msg);
            }
            log(msg);
        }
    }

    /**
     * Error Messages
     * <p>
     * Will only display the error messages if the error logging option is set to true in the configuration file
     *
     * @param msg
     */
    public void error(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&4[&cERROR&4]&e " + msg);
        if (Main.getReachConfig().ERROR_LOGGING){
            if (!Main.getReachConfig().COLOR_LOGS){
                msg = ChatColor.stripColor(msg);
            }
            log(msg);
        }
    }
}
