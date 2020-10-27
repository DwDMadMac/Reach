package net.ezenity.reach;

import net.ezenity.reach.command.CmdGui;
import net.ezenity.reach.command.CmdReload;
import net.ezenity.reach.configuration.Lang;
import net.ezenity.reach.listener.Tools;
import net.ezenity.reach.util.Logger;
import net.ezenity.reach.configuration.Config;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Reach Main Plugin Class
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 0.0.1
 */
public class Main extends JavaPlugin {
    /**
     * Main instance. Create an instance of this plugin.
     */
    private static Main instance;
    private static Config config;
    private static Lang lang;
    private static Logger logger;

    /**
     * Gets the instance of the main class
     *
     * @return Return Main instance
     */
    public static Main getInstance() {
        return instance;
    }

    public static void setInstance(Main instance) {
        Main.instance = instance;
    }

    public static Config getReachConfig() {
        return config;
    }

    public static void setReachConfig(Config config) {
        Main.config = config;
    }

    public static Lang getReachLang() {
        return lang;
    }

    public static void setReachLang(Lang lang) {
        Main.lang = lang;
    }

    public static Logger getReachLogger() {
        return logger;
    }

    public static void setReachLogger(Logger logger) {
        Main.logger = logger;
    }

    /**
     * This method is invoked when the plugin is enabled. When plugin is enabled, the config is reload,
     * lang is reload, events are registered, commands are registered and the plugin version is displayed.
     */
    @Override
    public void onEnable() {
        setInstance(this);

        // Yaml Files
        setReachConfig(new Config(this));
        setReachLang(new Lang(this, "lang-en.yml"));

        setReachLogger(new Logger());

        // Register events
        getServer().getPluginManager().registerEvents(new Tools(), this);

        // Register commands
        getCommand("reach").setExecutor(new CmdReload());
        getCommand("portal").setExecutor(new CmdGui());

        // Purpose of this extra logger is if the user wants colors applied.
        getReachLogger().info(getName() + " v" + Main.getInstance().getDescription().getVersion() + " enabled!");
    }

    /**
     * This method is invoked when the plugin is disabled. When the plugin is disabled, the plugin will out
     * to console that is has been disabled.
     */
    @Override
    public void onDisable() {
        getReachLogger().info(getName() + " disabled!");
    }
}
