package net.pl3x.reach.util;

import net.pl3x.reach.configuration.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Reach Logger Class
 * <p>
 * Custom utilities for a console messages
 */
public class Logger {
    /**
     * Logs plugin messages and sends to console with colors or not colors depending on configuration settings
     *
     * @param msg Send console message
     */
    private static void log(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&a[&7Reach&a]&r " + msg);
        if (!Config.COLOR_LOGS){
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
    public static void debug(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&2[&eDEBUG*2]&r " + msg);
        if (Config.DEBUG_MODE){
            if (!Config.COLOR_LOGS){
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
    public static void info(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&b[&7INFO&b]&f " + msg);
        if (Config.INFO_LOGGING) {
            if (!Config.COLOR_LOGS){
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
    public static void warn(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&6[&eWARN&6]&a " + msg);
        if (Config.WARN_LOGGING){
            if (!Config.COLOR_LOGS){
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
    public static void error(String msg) {
        msg = ChatColor.translateAlternateColorCodes('&', "&4[&cERROR&4]&e " + msg);
        if (Config.ERROR_LOGGING){
            if (!Config.COLOR_LOGS){
                msg = ChatColor.stripColor(msg);
            }
            log(msg);
        }
    }
}
