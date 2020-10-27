package net.ezenity.reach.configuration;

import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import net.ezenity.reach.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Reach Language Class
 * <p>
 * Here you will find all the default language options
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 0.0.1
 */
public class Lang extends YamlConfiguration {
    /**
     * This is the header for the language file. This will be displayed as a comment above all of the settings regardless what was inputted
     */
    private final String HEADER = "Main language file for Reach.";
    public String COMMAND_NO_PERMISSION;
    public String DISABLED_COMMAND;
    public String PLAYER_COMMAND;
    
    private void defaults() {
        COMMAND_NO_PERMISSION = this.getString("command.no-permission", "&4You do not have permission to use {getCommand}!");
        DISABLED_COMMAND = this.getString("command.disabled","&cThe {getDisabledCommand} &cis disabled.");
        PLAYER_COMMAND = this.getString("command.player","&4This command is only available to players!");
        plugin.getConfig().options().header(HEADER);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }

    /**
     * This method is utilized from applying all the language settings. This allows us to grab any of these static variables and apply them
     * throughout the rest of the plugin.
     */
    private void init() { }


    // ############################  DO NOT EDIT BELOW THIS LINE  ############################
    /**
     * Initialize plugin instance. we use this to initialize the config file.
     */
    private JavaPlugin plugin;
    private String defaultName;
    /**
     * Configuration File. Gets the default plugin folder and creates a new config file from the default provided config file with comments.
     */
    private File langFile;

    public Lang(JavaPlugin plugin, String defaultName) {
        this.plugin = plugin;
        this.defaultName = defaultName;
        this.langFile = new File(plugin.getDataFolder(), "lang-" + Main.getReachConfig().LANGUAGE + ".yml");

        defaults();
        reload();
    }

    /**
     * This method will reload the language file and its contents. If there is no language
     * file, then a default language file will be generated and then will load the language
     * file. The comments that are set within the language file will also not be overwritten.
     */
    public void reload() {
        if (!langFile.exists()) {
            try {
                langFile.getParentFile().mkdirs();
                langFile.createNewFile();
            } catch (Exception exception) {
                exception.printStackTrace();
                plugin.getLogger().severe("Error while creating the language file " + langFile.getName());
            }
        }

        try {
            load(langFile);

            if (defaultName != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(plugin.getResource(defaultName)));
                FileConfiguration langDefaults = YamlConfiguration.loadConfiguration(inputStreamReader);
                setDefaults(langDefaults);
                options.copyDefaults(true);
                inputStreamReader.close();
                try {
                    save(langFile);
                } catch (IOException exception) {
                    exception.printStackTrace();
                    plugin.getLogger().severe("Error while saving the language file " + langFile.getName());

                }
            }
            init();
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
            plugin.getLogger().severe("Error while loading the language file " + langFile.getName());
        }
    }

    /**
     * Sends a message to a recipient
     *
     * @param recipient Recipient of message
     * @param message   Message to send
     */
    public void send(CommandSender recipient, String message) {
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
    public void broadcast(String message) {
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
    public String colorize(String str) {
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
