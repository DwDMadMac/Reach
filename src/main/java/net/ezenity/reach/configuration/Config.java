package net.ezenity.reach.configuration;

import net.ezenity.reach.Main;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Reach Configuration Class
 * <p>
 * Here you will find all the default configuration options
 */
public class Config {
    private static final String HEADER = "The main configuration file for Reach.";
    public static boolean DEBUG_MODE;
    public static boolean COLOR_LOGS;
    public static boolean INFO_LOGGING;
    public static boolean WARN_LOGGING;
    public static boolean ERROR_LOGGING;
    public static String LANGUAGE_FILE;
    // Main portal: Name
    public static String MAIN_PORTAL_TITLE;
    // Main Portal: Close Inventory
    public static int CLOSE_INVENTORY_SLOT;
    public static String CLOSE_INVENTORY_TYPE;
    public static String CLOSE_INVENTORY_TITLE;
    public static String CLOSE_INVENTORY_LORE;
    // Main Portal: Tools Portal Icon
    public static int TOOLS_PORTAL_SLOT;
    public static String TOOLS_PORTAL_TYPE;
    public static String TOOLS_PORTAL_TITLE;
    public static String TOOLS_PORTAL_LORE;
    // Tools Portal: Tree Spawner
    public static boolean TREE_SPAWNER_ENABLED;
    public static int TREE_SPAWNER_SLOT;
    public static int TREE_SPAWNER_COOLDOWN;
    public static int TREE_SPAWNER_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_TYPE;
    public static String TREE_SPAWNER_TITLE;
    public static String TREE_SPAWNER_LORE;
    public static int TREE_SPAWNER_SPAWNED_IDENTIFIER;
    public static String TREE_SPAWNER_SPAWNED_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TITLE;
    public static String TREE_SPAWNER_SPAWNED_LORE;
    // Tools Portal: Flower Spawner
    // TODO: Make Flower Spawner settings
    // TODO: Make forcefield bump players back

    /**
     * Apply configuration options
     */
    private static void init() {
        DEBUG_MODE = config.getBoolean("debug-mode",true);
        COLOR_LOGS = config.getBoolean("color-logs",true);
        INFO_LOGGING = config.getBoolean("logging.info", true);
        WARN_LOGGING = config.getBoolean("logging.warn", true);
        ERROR_LOGGING = config.getBoolean("logging.error", true);
        LANGUAGE_FILE = config.getString("language-file", "lang-en.yml");
        MAIN_PORTAL_TITLE = config.getString("portal.main.portal-title","Main Reach Portal");
        // Main Portal: Close Inventory
        CLOSE_INVENTORY_SLOT = config.getInt("portal.main.close-inventory.slot", 0);
        CLOSE_INVENTORY_TYPE = config.getString("portal.main.close-inventory.type", "APPLE");
        CLOSE_INVENTORY_TITLE = config.getString("portal.main.close-inventory.title","&4Close Portal");
        CLOSE_INVENTORY_LORE = config.getString("portal.main.close-inventory.lore","\n&7Click to close Main\n&7Reach Portal.");
        // Main Portal: Tools Portal Icon
        TOOLS_PORTAL_SLOT = config.getInt("portal.main.tools-portal.slot",2);
        TOOLS_PORTAL_TYPE = config.getString("portal.main.tools-portal.type","DIAMOND_AXE");
        TOOLS_PORTAL_TITLE = config.getString("portal.main.tools-portal.title","&7Open Tools Portal");
        TOOLS_PORTAL_LORE = config.getString("portal.main.tools-portal.lore","Open Custom Tools Portal");
        // Tools Portal: Tree Spawner
        TREE_SPAWNER_ENABLED = config.getBoolean("portal.tools.tree-spawner.enabled",true);
        TREE_SPAWNER_SLOT = config.getInt("portal.tools.tree-spawner.slot",2);
        TREE_SPAWNER_COOLDOWN = config.getInt("portal.tools.tree-spawner.cooldown", 40);
        TREE_SPAWNER_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.particle.spawned-timer", 10);
        TREE_SPAWNER_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.particle.design", "sphere");
        TREE_SPAWNER_TYPE = config.getString("portal.tools.tree-spawner.type","WOODEN_AXE");
        TREE_SPAWNER_TITLE = config.getString("portal.tools.tree-spawner.title","Tree Spawner");
        TREE_SPAWNER_LORE = config.getString("portal.tools.tree-spawner.lore","&7Spawn a custom tree");
        TREE_SPAWNER_SPAWNED_IDENTIFIER = config.getInt("portal.tools.tree-spawner.spawned.identifier", 00);
        TREE_SPAWNER_SPAWNED_TYPE = config.getString("portal.tools.tree-spawner.spawned.type","WOODEN_AXE");
        TREE_SPAWNER_SPAWNED_TITLE = config.getString("portal.tools.tree-spawner.spawned.title","&2Tree Spawner");
        TREE_SPAWNER_SPAWNED_LORE = config.getString("portal.tools.tree-spawner.spawned.lore","&7Click location where you would\n&7like to spawn your &6Tree Type&7.");
    }

    // ############################  DO NOT EDIT BELOW THIS LINE  ############################

    private static final Main plugin = Main.getInstance();
    private static final FileConfiguration config = plugin.getConfig();

    /**
     * Reloads the configuration file
     */
    public static void reload() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        config.options().header(HEADER);
        Config.init();
    }
}
