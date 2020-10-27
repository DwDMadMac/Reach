package net.ezenity.reach.configuration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Reach Configuration Class
 * <p>
 * Here you will find all the default configuration options
 *
 * @author Ezenity
 * @version 2.0.0
 * @since 0.0.1
 */
public class Config extends YamlConfiguration {
    /**
     * This is the header for the configuration file. This will be displayed as a comment above all of the settings regardless what was inputted
     */
    public final String HEADER = "The main configuration file for Reach.";
    public boolean DEBUG_MODE;
    public boolean COLOR_LOGS;
    public boolean INFO_LOGGING;
    public boolean WARN_LOGGING;
    public boolean ERROR_LOGGING;
    public String LANGUAGE;
    // Main portal: Name
    public String MAIN_PORTAL_TITLE;
    // Main Portal: Close Inventory
    public int CLOSE_INVENTORY_SLOT;
    public String CLOSE_INVENTORY_TYPE;
    public String CLOSE_INVENTORY_TITLE;
    public String CLOSE_INVENTORY_LORE;
    // Main Portal: Tools Portal Icon
    public int TOOLS_PORTAL_SLOT;
    public String TOOLS_PORTAL_TYPE;
    public String TOOLS_PORTAL_TITLE;
    public String TOOLS_PORTAL_LORE;
    // Tools Portal: Tree Spawner
    public boolean TREE_SPAWNER_ENABLED;
    public int TREE_SPAWNER_SLOT;
    public int TREE_SPAWNER_COOLDOWN;
    public int TREE_SPAWNER_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_PARTICLE_DESIGN;
    public String TREE_SPAWNER_TYPE;
    public String TREE_SPAWNER_TITLE;
    public String TREE_SPAWNER_LORE;
    public int TREE_SPAWNER_SPAWNED_IDENTIFIER;
    public String TREE_SPAWNER_SPAWNED_TYPE;
    public String TREE_SPAWNER_SPAWNED_TITLE;
    public String TREE_SPAWNER_SPAWNED_LORE;
    ////  Tree Spawner Tool Portal  ////
    //// -> Acacia
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_LORE;
    //// -> Birch
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_LORE;
    //// -> Tall Birch
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_LORE;
    //// -> Spruce
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_LORE;
    //// -> Jungle Bush
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_LORE;
    //// -> Small Jungle
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_LORE;
    //// -> Jungle
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_LORE;
    //// -> Oak
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_LORE;
    //// -> Big Oak
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_LORE;
    //// -> Dark Oak
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_LORE;
    //// -> Cocoa
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_LORE;
    //// -> Swamp
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_LORE;
    //// -> Chorus Plant
    public boolean TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_ENABLED;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_ROW;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_COLUMN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN;
    public int TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_SPAWNED_TIMER;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_DESIGN;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TYPE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TITLE;
    public String TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_LORE;
    // TODO: Make Flower Spawner settings
    // TODO: Make Force Field bump players back

    private void defaults() {
        DEBUG_MODE = this.getBoolean("debug-mode",true);
        COLOR_LOGS = this.getBoolean("color-logs",true);
        INFO_LOGGING = this.getBoolean("logging.info", true);
        WARN_LOGGING = this.getBoolean("logging.warn", true);
        ERROR_LOGGING = this.getBoolean("logging.error", true);
        LANGUAGE = this.getString("language-file", "en");
        plugin.getConfig().options().header(HEADER);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }

    /**
     * This method is utilized from applying all the configuration settings. This allows us to grab any of these variables and apply them
     * throughout the rest of the plugin.
     */
    private void init() {
        MAIN_PORTAL_TITLE = this.getString("portal.main.portal-title","Main Reach Portal");
        // Main Portal: Close Inventory
        CLOSE_INVENTORY_SLOT = this.getInt("portal.main.close-inventory.slot", 0);
        CLOSE_INVENTORY_TYPE = this.getString("portal.main.close-inventory.type", "APPLE");
        CLOSE_INVENTORY_TITLE = this.getString("portal.main.close-inventory.title","&4Close Portal");
        CLOSE_INVENTORY_LORE = this.getString("portal.main.close-inventory.lore","\n&7Click to close Main\n&7Reach Portal.");
        // Main Portal: Tools Portal Icon
        TOOLS_PORTAL_SLOT = this.getInt("portal.main.tools-portal.slot",2);
        TOOLS_PORTAL_TYPE = this.getString("portal.main.tools-portal.type","DIAMOND_AXE");
        TOOLS_PORTAL_TITLE = this.getString("portal.main.tools-portal.title","&7Open Tools Portal");
        TOOLS_PORTAL_LORE = this.getString("portal.main.tools-portal.lore","Open Custom Tools Portal");
        // Tools Portal: Tree Spawner
        TREE_SPAWNER_ENABLED = this.getBoolean("portal.tools.tree-spawner.enabled",true);
        TREE_SPAWNER_SLOT = this.getInt("portal.tools.tree-spawner.slot",2);
        TREE_SPAWNER_COOLDOWN = this.getInt("portal.tools.tree-spawner.cooldown", 40);
        TREE_SPAWNER_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.particle.spawned-timer", 10);
        TREE_SPAWNER_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.particle.design", "sphere");
        TREE_SPAWNER_TYPE = this.getString("portal.tools.tree-spawner.type","WOODEN_AXE");
        TREE_SPAWNER_TITLE = this.getString("portal.tools.tree-spawner.title","Tree Spawner");
        TREE_SPAWNER_LORE = this.getString("portal.tools.tree-spawner.lore","&7Spawn a custom tree");
        TREE_SPAWNER_SPAWNED_IDENTIFIER = this.getInt("portal.tools.tree-spawner.spawned.identifier", 001);
        TREE_SPAWNER_SPAWNED_TYPE = this.getString("portal.tools.tree-spawner.spawned.type","WOODEN_AXE");
        TREE_SPAWNER_SPAWNED_TITLE = this.getString("portal.tools.tree-spawner.spawned.title","&2Tree Spawner");
        TREE_SPAWNER_SPAWNED_LORE = this.getString("portal.tools.tree-spawner.spawned.lore","&7Click location where you would\n&7like to spawn your &6Tree Type&7.");
        ////  Tree Spawner Tool Portal  ////
        //// -> Acacia
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.acacia.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.slot-column", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.acacia.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.type", "ACACIA_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.title", "Acacia");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_ACACIA_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.acacia.lore",
                "&7Click here to spawn\n&7the Acacia tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Birch
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.birch.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.slot-column", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.birch.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.type", "BIRCH_LEAVES");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.title", "Birch");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIRCH_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.birch.lore",
                "&7Click here to spawn\n&7the Birch tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Tall Birch
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.slot-column", 2);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.type", "BIRCH_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.title", "Tall Birch");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_TALL_BIRCH_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.tall-birch.lore",
                "&7Click here to spawn\n&7the Tall Birch tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Spruce
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.spruce.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.slot-column", 3);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.spruce.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.type", "SPRUCE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.title", "Spruce");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SPRUCE_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.spruce.lore",
                "&7Click here to spawn\n&7the Spruce tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Jungle Bush
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.slot-column", 4);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.type", "JUNGLE_LEAVES");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.title", "Jungle Bush");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_BUSH_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle-bush.lore",
                "&7Click here to spawn\n&7the Jungle Bush tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Small Jungle
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.slot-column", 5);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.type", "STRIPPED_JUNGLE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.title", "Small Jungle");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SMALL_JUNGLE_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.small-jungle.lore",
                "&7Click here to spawn\n&7the Small Jungle tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Jungle
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.jungle.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.slot-column", 6);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.jungle.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.type", "JUNGLE_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.title", "Jungle");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_JUNGLE_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.jungle.lore",
                "&7Click here to spawn\n&7the Jungle tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.oak.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.slot-column", 7);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.oak.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.type", "OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.title", "Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_OAK_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.oak.lore",
                "&7Click here to spawn\n&7the Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Big Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.big-oak.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.slot-row", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.slot-column", 8);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.big-oak.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.type", "STRIPPED_OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.title", "Big Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_BIG_OAK_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.big-oak.lore",
                "&7Click here to spawn\n&7the Big Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Dark Oak
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.slot-column", 0);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.type", "DARK_OAK_LOG");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.title", "Dark Oak");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_DARK_OAK_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.dark-oak.lore",
                "&7Click here to spawn\n&7the Dark Oak tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Cocoa
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.cocoa.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.slot-column", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.cocoa.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.type", "COCOA_BEANS");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.title", "Cocoa");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_COCOA_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.cocoa.lore",
                "&7Click here to spawn\n&7the Cocoa tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Swamp
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.swamp.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.slot-column", 2);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.swamp.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.type", "VINE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.title", "Swamp");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_SWAMP_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.swamp.lore",
                "&7Click here to spawn\n&7the Swamp tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
        //// -> Chorus Plant
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_ENABLED = this.getBoolean("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.enabled", true);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_ROW = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.slot-row", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_SLOT_COLUMN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.slot-column", 3);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_COOLDOWN = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.cooldown", 60);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_SPAWNED_TIMER = this.getInt("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.particle-spawned-timer", 1);
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.particle-type", "EXPLOSION_HUGE");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_PARTICLE_DESIGN = this.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.particle-design", "explode");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TYPE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.type", "CHORUS_PLANT");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_TITLE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.title", "Chorus Plant");
        TREE_SPAWNER_SPAWNED_TOOL_PORTAL_CHORUS_PLANT_LORE = this.getString("portal.tools.tree-spawner.spawned.tool-portal.chorus-plant.lore",
                "&7Click here to spawn\n&7the Chorus Plant tree type.\n\n&7After the tree gas\n&7spawned, the tool will\n&7be removed from your spawn.");
    }

    // ############################  DO NOT EDIT BELOW THIS LINE  ############################
    /**
     * Initialize plugin instance. we use this to initialize the config file.
     */
    private JavaPlugin plugin;
    /**
     * Configuration File. Gets the default plugin folder and creates a new config file from the default provided config file with comments.
     */
    private File configFile;
    /**
     * Config file. set a custom file name for settings within the plugin.
     */
    private String configName;

    public Config(JavaPlugin plugin) {
        this.plugin = plugin;
        this.configName = "config.yml";
        this.configFile = new File(plugin.getDataFolder(), configName);

        defaults(); // TODO: Make sure this works
        reload();
    }

    /**
     * This method will reload the configuration file(s) and its contents. If there is no configuration,
     * then the default configuration file will be generated and then will load the configuration file.
     * Another thing to note is that this will not overwrite the comments that are set inside a config file.
     */
    public void reload() {
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
                plugin.getLogger().severe("Error while creating the config file " + configFile.getName());
            }
        }

        try {
            load(configFile);

            if (configFile != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(plugin.getResource(configName)));
                FileConfiguration configDefaults = YamlConfiguration.loadConfiguration(inputStreamReader);
                setDefaults(configDefaults);
                options.copyDefaults(true);
                inputStreamReader.close();
                try {
                    save(configFile);
                } catch (IOException exception) {
                    exception.printStackTrace();
                    plugin.getLogger().severe("Error while saving the config file " + configFile.getName());
                }
            }
            init();
        } catch (Exception exception) {
            exception.printStackTrace();
            plugin.getLogger().severe("Error while loading the config file " + configFile.getName());
        }
    }
}
