package net.ezenity.reach;

import net.ezenity.reach.command.CmdMainGui;
import net.ezenity.reach.command.CmdReload;
import net.ezenity.reach.listener.ToolsPortalListener;
import net.ezenity.reach.util.Logger;
import net.ezenity.reach.configuration.Config;
import net.ezenity.reach.configuration.Lang;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Reach Main Plugin Class
 *
 * @author DwDMadMac
 */
public class Main extends JavaPlugin {
    private static Main instance;

    /**
     * Constructor Instance of the main class
     */
    public Main() {
        instance = this;
    }

    /**
     * This method is invoked when the plugin is enabled
     */
    @Override
    public void onEnable() {
        Config.reload();
        Lang.reload();

        // Register events
//        getServer().getPluginManager().registerEvents(new MainPortalListener(this), this);
        getServer().getPluginManager().registerEvents(new ToolsPortalListener(), this);

        // Register commands
        getCommand("reach").setExecutor(new CmdReload(this));
        getCommand("portal").setExecutor(new CmdMainGui(this));

        Logger.info(getName() + " v" + Main.getInstance().getDescription().getVersion() + " enabled!");
    }

    /**
     * This method is invoked when the plugin is disabled
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
