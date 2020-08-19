package net.ezenity.reach.configuration;

import java.io.File;

import net.ezenity.reach.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Reach Language Class
 * <p>
 * Here you will find all the default language options
 */
public class Lang {
    /**
     * This is the header for the language file. This will be displayed as a comment above all of the settings regardless what was inputted
     */
    private static final String HEADER = "Main language file for Reach.";
    public static String COMMAND_NO_PERMISSION;
    public static String DISABLED_COMMAND;
    public static String PLAYER_COMMAND;

    /**
     * This method is utilized from applying all the language settings. This allows us to grab any of these static variables and apply them
     * throughout the rest of the plugin.
     */
    private static void init() {
        COMMAND_NO_PERMISSION = config.getString("command.no-permission", "&4You do not have permission to use {getCommand}!");
        DISABLED_COMMAND = config.getString("command.disabled","&cThe {getDisabledCommand} &cis disabled.");
        PLAYER_COMMAND = config.getString("command.player","&4This command is only available to players!");
    }


    // ############################  DO NOT EDIT BELOW THIS LINE  ############################
    /**
     * Initialize plugin instance. we use this to initialize the config file.
     */
    private static final Main plugin = Main.getInstance();
    /**
     * Language file. Gets the default set language file from the default config file.
     */
    private static final String langFile = Config.LANGUAGE_FILE;
    /**
     * Configuration File. Gets the default plugin folder and creates a new config file from the default provided config file with comments.
     */
    private static final File configFile = new File(plugin.getDataFolder(), langFile);;
    /**
     * Config file configuration. This is used for creating the files settings general speaking.
     */
    private static FileConfiguration config;

    /**
     * This method will reload the language file and its contents. If there is no language
     * file, then a default language file will be generated and then will load the language
     * file. The comments that are set within the language file will also not be overwritten.
     */
    public static void reload() {
        if (!configFile.exists()) {
            plugin.saveResource(langFile, false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        config.options().header(HEADER);
        Lang.init();
    }

    /**
     * Sends a message to a recipient
     *
     * @param recipient Recipient of message
     * @param message   Message to send
     */
    public static void send(CommandSender recipient, String message) {
        if (recipient != null) {
            for (String part : colorize(message).split("\n")) {
                if (part != null && !part.isEmpty()) {
                    recipient.sendMessage(part);
                }
            }
        }
    }

    /**
     * Broadcast a custom message to server
     *
     * @param message Message to broadcast
     */
    public static void broadcast(String message) {
        for (String part : colorize(message).split("\n")) {
            Bukkit.getOnlinePlayers().forEach(recipient -> recipient.sendMessage(part));
            Bukkit.getConsoleSender().sendMessage(part);
        }
    }

    /**
     * Colorize a String
     *
     * @param str String to colorize
     * @return Return a colorized string
     */
    // TODO: Figure out why the new line is disappearing!! !IMPORTANT!
    public static String colorize(String str) {
        if (str == null) {
            return "";
        }
        str = ChatColor.translateAlternateColorCodes('&', str);
        if (ChatColor.stripColor(str).isEmpty()) {
            return "";
        }
        return str;
    }
}
