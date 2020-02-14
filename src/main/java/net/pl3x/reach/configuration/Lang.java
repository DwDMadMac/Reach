package net.pl3x.reach.configuration;

import com.google.common.base.Throwables;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import net.pl3x.reach.Main;
import net.pl3x.reach.util.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Reach Language Class
 * <p>
 * Here you will find all of the default language options
 */
public class Lang {
    private static File configFile;
    private static YamlConfiguration config;

    private static final String HEADER = "The main Language file for Reach.";

    public static String COMMAND_NO_PERMISSION;
    public static String PLAYER_COMMAND;
    public static String DISABLED_COMMAND;

    /**
     * Apply the language options
     */
    private static void init() {
        // TODO: Create lang.yml file
        COMMAND_NO_PERMISSION = getString("command-no-permission", "&4You do not have permission for that command!");
        PLAYER_COMMAND = getString("player-command","&4This command is only available to players!");
        DISABLED_COMMAND = getString("disabled-command","&cThe {getDisabledNamed} &cis disabled.");
    }


    // ############################  DO NOT EDIT BELOW THIS LINE  ############################

    /**
     * Reload the language file
     */
    @SuppressWarnings("deprecation")
    public static void reload() {
        Main plugin = Main.getInstance();
        if (configFile == null) {
            configFile = new File(plugin.getDataFolder(), Config.LANGUAGE_FILE);
        }

        config = new YamlConfiguration();

        try {
            config.load(configFile);
        } catch (IOException ignore) {
            if (Config.DEBUG_MODE) {
                Logger.debug("onLangReload | IOException occurred, printStackTrace() below.");
                ignore.printStackTrace();
            }
        } catch (InvalidConfigurationException ex) {
            if (Config.DEBUG_MODE) {
                Logger.debug("onLangReload | InvalidConfigurationException occurred, printStackTrace() below.");
                ex.printStackTrace();
            }
            Bukkit.getLogger().log(Level.SEVERE, "Could not load " + Config.LANGUAGE_FILE + ", please correct your syntax errors", ex);
            throw Throwables.propagate(ex);
        }
        config.options().header(HEADER);
        config.options().copyDefaults(true);

        Lang.init();

        try {
            config.save(configFile);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save " + configFile, ex);
        }
    }

    /**
     * Gets the string path and the option that is set String with that path
     *
     * @param path Get String Path
     * @param def Path message
     * @return Return the String path and path message
     */
    private static String getString(String path, String def) {
        config.addDefault(path, def);
        return config.getString(path, config.getString(path));
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
