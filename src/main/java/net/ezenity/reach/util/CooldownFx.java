package net.ezenity.reach.util;

import org.bukkit.entity.Player;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownFx {
    private Map<UUID, Long> MAIN_COOLDOWN = new HashMap<>();



/*
 * Cooldown sample One
 */
    private static final Map<UUID, Map<String, Long>> COOLDOWNS = new HashMap<>();
    private static Map<String, Long> SPECIFIC_COOLDOWN;

    public static void addNewCooldown(Player player, String cooldownName, Long time){
        SPECIFIC_COOLDOWN = COOLDOWNS.get(player.getUniqueId());
        COOLDOWNS.putIfAbsent(player.getUniqueId(), SPECIFIC_COOLDOWN);
    }

    public static void addToCooldown(Player player, String cooldownName, Long time){
//        Map<String, Long> cooldown = COOLDOWNS.get(player.getUniqueId());
//        COOLDOWNS.putIfAbsent(player.getUniqueId(), cooldown);
        COOLDOWNS.putIfAbsent(player.getUniqueId(), SPECIFIC_COOLDOWN);
    }

/*
 * Cooldown sample Two
 */
    //hashmap storing the data
    private static HashMap<String, Date> cooldowns = new HashMap<>();

    public static boolean cooldown(final Long mil, final Player p) {
        //If the player is registered in the hashmap.
        if (cooldowns.containsKey(p.getName())) {
            //Check where I put the info in the hashmap, but basically I set the cooldown to current time + extra time. So if the current time catches up to the stored time, then the cooldown is over.
            if (cooldowns.get(p.getName()).getTime() > new Date().getTime()) {
                return false;
            } else {
                //Cooldown is over
                cooldowns.remove(p.getName());
                return true;
            }
        } else {
            //Cooldown is not set, so we will set the cooldown then return false.
            cooldowns.put(p.getName() , new Date(new Date().getTime() + mil));
            return false;
        }
    }
}
