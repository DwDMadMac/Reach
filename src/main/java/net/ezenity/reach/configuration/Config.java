package net.ezenity.reach.configuration;

import net.ezenity.reach.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Reach Configuration Class
 * <p>
 * Here you will find all the default configuration options
 */
public class Config {
    /**
     * This is the header for the configuration file. This will be displayed as a comment above all of the settings regardless what was inputted
     */
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
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_LORE;
    //// -> Birch
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_LORE;
    //// -> Tall Birch
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_LORE;
    //// -> Spruce
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_LORE;
    //// -> Jungle Bush
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_LORE;
    //// -> Small Jungle
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_LORE;
    //// -> Jungle
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_LORE;
    //// -> Oak
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_LORE;
    //// -> Big Oak
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_LORE;
    //// -> Dark Oak
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_LORE;
    //// -> Cocoa
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_LORE;
    //// -> Swamp
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_LORE;
    //// -> Chorus Plant
    public static boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_ENABLED;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_ROW;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_COLUMN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN;
    public static int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_SPAWNED_TIMER;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_DESIGN;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TYPE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TITLE;
    public static String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_LORE;
    // TODO: Make Flower Spawner settings
    // TODO: Make Force Field bump players back

    /**
     * This method is utilized from applying all the configuration settings. This allows us to grab any of these static variables and apply them
     * throughout the rest of the plugin.
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
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.acacia.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.slot-column", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.type", "ACACIA_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.title", "Acacia");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.lore",
                "&7Click here to spawn\n&7the Acacia tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Birch
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.birch.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.slot-column", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.type", "BIRCH_LEAVES");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.title", "Birch");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.lore",
                "&7Click here to spawn\n&7the Birch tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Tall Birch
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.slot-column", 2);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.type", "BIRCH_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.title", "Tall Birch");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.lore",
                "&7Click here to spawn\n&7the Tall Birch tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Spruce
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.spruce.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.slot-column", 3);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.type", "SPRUCE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.title", "Spruce");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.lore",
                "&7Click here to spawn\n&7the Spruce tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Jungle Bush
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.slot-column", 4);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.type", "JUNGLE_LEAVES");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.title", "Jungle Bush");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.lore",
                "&7Click here to spawn\n&7the Jungle Bush tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Small Jungle
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.slot-column", 5);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.type", "STRIPPED_JUNGLE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.title", "Small Jungle");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.lore",
                "&7Click here to spawn\n&7the Small Jungle tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Jungle
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.jungle.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.slot-column", 6);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.type", "JUNGLE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.title", "Jungle");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.lore",
                "&7Click here to spawn\n&7the Jungle tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.oak.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.slot-column", 7);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.type", "OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.title", "Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.lore",
                "&7Click here to spawn\n&7the Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Big Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.big-oak.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.slot-column", 8);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.type", "STRIPPED_OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.title", "Big Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.lore",
                "&7Click here to spawn\n&7the Big Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Dark Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.slot-column", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.type", "DARK_OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.title", "Dark Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.lore",
                "&7Click here to spawn\n&7the Dark Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Cocoa
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.cocoa.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.slot-column", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.type", "COCOA_BEANS");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.title", "Cocoa");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.lore",
                "&7Click here to spawn\n&7the Cocoa tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Swamp
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.swamp.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.slot-column", 2);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.type", "VINE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.title", "Swamp");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.lore",
                "&7Click here to spawn\n&7the Swamp tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Chorus Plant
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_ENABLED = config.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_ROW = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_COLUMN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.slot-column", 3);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_SPAWNED_TIMER = config.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_DESIGN = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TYPE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.type", "CHORUS_PLANT");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TITLE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.title", "Chorus Plant");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_LORE = config.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.lore",
                "&7Click here to spawn\n&7the Chorus Plant tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
    }

    // ############################  DO NOT EDIT BELOW THIS LINE  ############################
    /**
     * Initialize plugin instance. we use this to initialize the config file.
     */
    private static final Main plugin = Main.getInstance();
    /**
     * Configuration File. Gets the default plugin folder and creates a new config file from the default provided config file with comments.
     */
    private static  final File configFile = new File(plugin.getDataFolder(), "config.yml");
    /**
     * Config file configuration. This is used for creating the files settings general speaking.
     */
    private static FileConfiguration config;

    /**
     * This method will reload the configuration file(s) and its contents. If there is no configuration,
     * then the default configuration file will be generated and then will load the configuration file.
     * Another thing to note is that this will not overwrite the comments that are set inside a config file.
     */
    public static void reload() {
        if (!configFile.exists())
            plugin.saveResource("config.yml", false);

        config = YamlConfiguration.loadConfiguration(configFile);
        config.options().header(HEADER);
        Config.init();
    }
}
