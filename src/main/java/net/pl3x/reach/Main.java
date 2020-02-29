package net.pl3x.reach;

import net.pl3x.reach.command.CmdMainGui;
import net.pl3x.reach.command.CmdReload;
import net.pl3x.reach.configuration.Config;
import net.pl3x.reach.configuration.Lang;
import net.pl3x.reach.util.Logger;
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
