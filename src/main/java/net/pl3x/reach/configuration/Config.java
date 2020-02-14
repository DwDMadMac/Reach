package net.pl3x.reach.configuration;

import com.google.common.base.Throwables;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import net.pl3x.reach.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Reach Configuration Class
 * <p>
 * Here you will find all of the default configuration options
 */
public class Config {
    private static final String HEADER = "The main configuration file for Reach.";
    public static boolean DEBUG_MODE;
    public static boolean COLOR_LOGS;
    public static boolean INFO_LOGGING;
    public static boolean WARN_LOGGING;
    public static boolean ERROR_LOGGING;
    public static String LANGUAGE_FILE;

    /**
     * Apply configuration options
     */
    private static void init() {
        // TODO: Create config.yml file
        DEBUG_MODE = getBoolean("debug-mode",false);
        COLOR_LOGS = getBoolean("color-logs",true);
        INFO_LOGGING = getBoolean("info-logging", true);
        WARN_LOGGING = getBoolean("warn-logging", true);
        ERROR_LOGGING = getBoolean("error-logging", true);
        LANGUAGE_FILE = getString("language-file", "lang-en.yml");
    }

    // ############################  DO NOT EDIT BELOW THIS LINE  ############################

    /**
     * Reload the configuration file
     */
    @SuppressWarnings("deprecation")
    public static void reload() {
        Main plugin = Main.getInstance();
        plugin.saveDefaultConfig();
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException ignore) {
            ignore.printStackTrace();
        } catch (InvalidConfigurationException ex) {
            ex.printStackTrace();
            Bukkit.getLogger().log(Level.SEVERE, "Could not load config.yml, please correct your syntax errors", ex);
            throw Throwables.propagate(ex);
        }
        config.options().header(HEADER);
        config.options().copyDefaults(true);

        Config.init();

        try {
            config.save(configFile);
        } catch (IOException ex) {
            Bukkit.getLogger().log(Level.SEVERE, "Could not save " + configFile, ex);
        }
    }

    private static YamlConfiguration config;

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
     * Gets a boolean path and the option that is set to that boolean path
     *
     * @param path Get boolean path
     * @param def Get boolean
     * @return Return the boolean path and path boolean
     */
    private static boolean getBoolean(String path, boolean def) {
        config.addDefault(path, def);
        return config.getBoolean(path, config.getBoolean(path));
    }

    /**
     * Gets an Integer path and the option that is set to that integer path
     *
     * @param path Get integer path
     * @param def Get integer
     * @return Return the integer path and path integer
     */
    private static int getInt(String path, int def) {
        config.addDefault(path, def);
        return config.getInt(path, config.getInt(path));
    }
}
