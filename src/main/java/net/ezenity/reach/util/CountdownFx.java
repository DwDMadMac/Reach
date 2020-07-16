package net.ezenity.reach.util;

import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A very simple countdown library
 *
 * @author aadnk
 */
public class CountdownFx {
    private static final Map<UUID, Map<String, Long>> COUNTDOWNS = new HashMap<>();

    /**
     * Update a countdown for the specified player.
     *
     * @param playerID get player uuid
     * @param countdownKey custom countdown key
     * @param delay - number of seconds until the countdown will expire again.
     * @return The previous number of milliseconds until expiration.
     */
    public static void setCountdown(UUID playerID, String countdownKey, long delay) {
//        return calculateRemainder(
//                countdowns.put(
//                    player.getUniqueId(),
//                    countdownKey,
//                    /*secToMilli(delay)*/System.currentTimeMillis() + delay
//                ));

//        return calculateRemainder(COUNTDOWNS.computeIfAbsent(playerID, k -> new HashMap<>())
//                .put(countdownKey, delay));
        COUNTDOWNS.computeIfAbsent(playerID, k -> new HashMap<>())
                .put(countdownKey, System.currentTimeMillis() + (delay * 1000));
    }

    /**
     * Retrieve all the countdowns that are associated with the players UUID and
     * the given countdown key.
     *
     * @param countdownKey - countdown key to locate
     * @return all the counts that are associated with the countdown key
     */
    public static Map<UUID, Long> getKeyCountdowns(String countdownKey) {
        Map<UUID, Long> allKeyCountdowns = new HashMap<>();
        COUNTDOWNS.forEach((key, value) -> {
            Long expire = value.get(countdownKey);
            if (expire != null)
                allKeyCountdowns.put(key, expire);
        });
        return Collections.unmodifiableMap(allKeyCountdowns);
    }

    /**
     * Determine if a given countdown has expired. If it has not expired, countdown will
     *  return TRUE.
     *
     * @param playerID get player uuid
     * @param countdownKey custom countdown key
     * @return TRUE if the countdown is still active, FALSE otherwise.
     */
    public static boolean countdownActive(UUID playerID, String countdownKey) {
        Map<String, Long> countdowns = COUNTDOWNS.get(playerID);
        return countdowns != null && countdowns.containsKey(countdownKey);
    }

    /**
     * Get the remaining seconds left for the specific countdown key that is
     * associated with the players uuid.
     *
     * @param playerID get player uuid
     * @param countdownKey custom countdown key
     * @return if countdown is null return 0, else return seconds left for countdown
     */
    public static int countdownSecondsRemaining(UUID playerID, String countdownKey){
        Map<String, Long> countdowns = COUNTDOWNS.get(playerID);
        if (countdowns == null)
            return 0;
        Long expireTime = countdowns.get(countdownKey);
        if (expireTime == null)
            return 0;
        return (int) ((expireTime - System.currentTimeMillis()) / 1000);
    }

    /**
     * Remove the given countdown key associated with the players uuid.
     *
     * @param playerID player uuid
     * @param countdownKey custom countdown key
     */
    public static void removeCountdowns(UUID playerID, String countdownKey) {
        Map<String, Long> countdowns = COUNTDOWNS.get(playerID);
        if (countdowns != null)
            countdowns.remove(countdownKey);
    }

    /**
     * Remove a specific countdown associated to a specific player.
     * 
     * @param player get given player
     * @param countdownKey get custom countdown key
     */
    public static void removeSpecificCountdown(Player player, String countdownKey) {
        COUNTDOWNS.remove(player.getUniqueId(), countdownKey);
    }

    private static long secToMilli(int seconds) {
        return seconds * 1000;
    }

    /**
     * Calculate the time left until it is due to expire. Once expired it will fall back to
     * {@link Long#MIN_VALUE}.
     *
     * @param expireTime expire time in milliseconds
     * @return time left in milliseconds, if not null
     */
    private static long calculateRemainder(Long expireTime) {
        return expireTime != null ? expireTime - System.currentTimeMillis() : Long.MIN_VALUE;
    }
}