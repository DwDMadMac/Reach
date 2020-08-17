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
    ////  Tree Spawner Tool Portal  ////
    //// -> Acacia
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_LORE;
    //// -> Birch
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_LORE;
    //// -> Tall Birch
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_LORE;
    //// -> Spruce
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_LORE;
    //// -> Jungle Bush
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_LORE;
    //// -> Small Jungle
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_LORE;
    //// -> Jungle
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_LORE;
    //// -> Oak
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_LORE;
    //// -> Big Oak
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_LORE;
    //// -> Dark Oak
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_LORE;
    //// -> Cocoa
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_LORE;
    //// -> Swamp
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_LORE;
    //// -> Chorus Plant
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_LORE;
    // TODO: Make Flower Spawner settings
    // TODO: Make Force Field bump players back

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
        TREE_SPAWNER_SPAWNED_IDENTIFIER = config.getInt("portal.tools.tree-spawner.spawned.identifier", 001);
        TREE_SPAWNER_SPAWNED_TYPE = config.getString("portal.tools.tree-spawner.spawned.type","WOODEN_AXE");
        TREE_SPAWNER_SPAWNED_TITLE = config.getString("portal.tools.tree-spawner.spawned.title","&2Tree Spawner");
        TREE_SPAWNER_SPAWNED_LORE = config.getString("portal.tools.tree-spawner.spawned.lore","&7Click location where you would\n&7like to spawn your &6Tree Type&7.");
        ////  Tree Spawner Tool Portal  ////
        //// -> Acacia
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.type", "ACACIA_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.title", "Acacia");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.lore",
                "&7Click here to spawn\n&7the Acacia tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Birch
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.type", "BIRCH_LEAVES");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.title", "Birch");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.lore",
                "&7Click here to spawn\n&7the Birch tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Tall Birch
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.type", "BIRCH_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.title", "Tall Birch");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.lore",
                "&7Click here to spawn\n&7the Tall Birch tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Spruce
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.type", "SPRUCE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.title", "Spruce");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.lore",
                "&7Click here to spawn\n&7the Spruce tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Jungle Bush
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.type", "JUNGLE_LEAVES");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.title", "Jungle Bush");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.lore",
                "&7Click here to spawn\n&7the Jungle Bush tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Small Jungle
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.type", "STRIPPED_JUNGLE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.title", "Small Jungle");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.lore",
                "&7Click here to spawn\n&7the Small Jungle tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Jungle
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.type", "JUNGLE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.title", "Jungle");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.lore",
                "&7Click here to spawn\n&7the Jungle tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.type", "OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.title", "Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.lore",
                "&7Click here to spawn\n&7the Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Big Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.type", "STRIPPED_OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.title", "Big Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.lore",
                "&7Click here to spawn\n&7the Big Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Dark Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.type", "DARK_OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.title", "Dark Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.lore",
                "&7Click here to spawn\n&7the Dark Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Cocoa
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.type", "COCOA_BEANS ");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.title", "Cocoa");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.lore",
                "&7Click here to spawn\n&7the Cocoa tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Swamp
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.type", "VINE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.title", "Swamp");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.lore",
                "&7Click here to spawn\n&7the Swamp tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Chorus Plant
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.type", "CHORUS_PLANT");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.title", "Chorus Plant");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.lore",
                "&7Click here to spawn\n&7the Chorus Plant tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
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
