package net.pl3x.reach.configuration;

import java.io.File;
import net.pl3x.reach.Main;
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
    private static final String HEADER = "Main language file for Reach.";
    public static String COMMAND_NO_PERMISSION;
    public static String PLAYER_COMMAND;
    public static String DISABLED_COMMAND;

    /**
     * Apply the language options
     */
    private static void init() {
        COMMAND_NO_PERMISSION = config.getString("command-no-permission", "&4You do not have permission to use {getCommand}!");
        PLAYER_COMMAND = config.getString("player-command","&4This command is only available to players!");
        DISABLED_COMMAND = config.getString("disabled-command","&cThe {getDisabledNamed} &cis disabled.");
    }


    // ############################  DO NOT EDIT BELOW THIS LINE  ############################

    private static Main plugin = Main.getInstance();
    private static String langFile = Config.LANGUAGE_FILE;
    private static File configFile = new File(plugin.getDataFolder(), langFile);
    private static FileConfiguration config;

    /**
     * Reload the language file
     */
    @SuppressWarnings("deprecation")
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
                recipient.sendMessage(part);
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
