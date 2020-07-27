package net.ezenity.reach.util.countdownFx;

import net.ezenity.reach.util.countdownFx.CustomIndex;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A very simple countdown library
 *
 * TODO: NEEDED Methods Below
     - public Map<UUID, Long> getAllTimers();
     - public Map<String, Long> getSpecificTimer();
     - public boolean activatedTimers();
     - public void removeTimer();
     - public void removeSpecificTimer();
 *
 * @author anthonymmacallister
 */
public class Countdown {
    /**
     * Countdown map. Create a hashmap using two string objects from our CustomIndex class.
     */
    private static final Map<CustomIndex, Long> COUNTDOWNS = new HashMap<>();

    /**
     * We use this method to declare our custom unique String Objects which will be
     * return as an integer type value, representing the returned index. This method
     * will allow you to input two String objects for a map key using the same value.
     *
     * @param playerID get player uuid
     * @param countdownKey get custom countdown key
     * @return hash code value for the two given string objects
     */
    private static CustomIndex customIndexHash(UUID playerID, String countdownKey){
        return new CustomIndex(playerID.toString(), countdownKey);
    }

    /**
     * Set the specific countdown to a players UUID. This method will also use a specific
     * countdown key to identify the time left of the countdown. Both playerID and countdownKey
     * are keyed in to create a unique hashCode. The delay is inputted as seconds for
     * configuration purposes on end-user. Use a simply conversion to change the integer
     * into a long for milliseconds. The converted seconds is then added to the current system
     * time in milliseconds for easy mapping.
     *
     * @param playerID get player uuid
     * @param countdownKey get custom countdown key
     * @param delay number of seconds until the countdown will expire
     */
    public static void setCountdown(UUID playerID, String countdownKey, int delay){
        long delayConvert = (long) delay * 1000;
        COUNTDOWNS.put(customIndexHash(playerID, countdownKey), delayConvert + System.currentTimeMillis());
    }

    /**
     * This method will determine if a countdown is still active. If the countdown is no longer active
     * the method will return false. If the countdown is still active, the method will return true.
     *
     * @param playerID get player uuid
     * @param countdownKey get custom countdown key
     * @return TRUE if the countdown is still active, FALSE otherwise.
     */
    public static boolean countdownActive(UUID playerID, String countdownKey) {
        return System.currentTimeMillis() >= getCountdown(playerID, countdownKey);
    }

    /**
     * This will get the added system milliseconds for the given hashCode of the playerID and
     * countdown key. If the system time in milliseconds have passed, it will return 0L instead.
     * This method is used to compute for active countdowns. For an example of how to use this
     * method, refer to:
     * {@link net.ezenity.reach.util.particleFx.ParticleSpawnedTask#setParticleTask(Player, Particle, String, int, int)}
     *
     * @param playerID get player uuid
     * @param countdownKey get custom countdown key
     * @return the long value associated with the index hash
     */
    public static long getCountdown(UUID playerID, String countdownKey) {
        return COUNTDOWNS.getOrDefault(customIndexHash(playerID, countdownKey), 0L);
    }
}