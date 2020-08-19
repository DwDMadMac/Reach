package net.ezenity.reach;

import net.ezenity.reach.command.CmdMainGui;
import net.ezenity.reach.command.CmdReload;
import net.ezenity.reach.listener.ToolsListener;
import net.ezenity.reach.util.Logger;
import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.configuration.Lang;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Reach Main Plugin Class
 *
 * @author DwDMadMac
 * @version v1.0.0
 */
public class Main extends JavaPlugin {
    /**
     * Main instance. Create an instance of this plugin.
     */
    private static Main instance;

    /**
     * Constructor Instance of the main class
     */
    public Main() {
        instance = this;
    }

    /**
     * This method is invoked when the plugin is enabled. When plugin is enabled, the config is reload,
     * lang is reload, events are registered, commands are registered and the plugin version is displayed.
     */
    @Override
    public void onEnable() {
        Config.reload();
        Lang.reload();

        // Register events
        getServer().getPluginManager().registerEvents(new ToolsListener(), this);

        // Register commands
        getCommand("reach").setExecutor(new CmdReload(this));
        getCommand("portal").setExecutor(new CmdMainGui());

        Logger.info(getName() + " v" + Main.getInstance().getDescription().getVersion() + " enabled!");
    }

    /**
     * This method is invoked when the plugin is disabled. When the plugin is disabled, the plugin will out
     * to console that is has been disabled.
     */
    @Override
    public void onDisable() {
        Logger.info(getName() + " disabled!");
    }

    /**
     * Gets the instance of the main class
     *
     * @return Return Main instance
     */
    public static Main getInstance() {
        return instance;
    }
}
