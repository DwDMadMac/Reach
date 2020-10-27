package net.ezenity.reach.Fx.countdown;


import java.util.Map;

/**
 * Timer interface. This will allows us to create custom countdowns, timers, cooldowns or
 * anything that is requiring some type of double key comparison with one value.
 *
 * @author Ezenity
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Timer<K1, K2, V> {
    /**
     * Get the value which the specified key is mapped. If no map is present this will return null instead
     *
     * @return value to which the specified key is mapped or null if the map contains no mapping for the key
     */
    Map<K1, V> getMap1();
    /**
     * Get the value which the specified key is mapped. If no map is present this will return null instead
     *
     * @return value to which the specified key is mapped or null if the map contains no mapping for the key
     */
    Map<K2, V> getMap2();
    /**
     * This method will put both mapped keys to the specified value.
     *
     * @param key1 key which is associated with value.
     * @param key2 key which is associated with value.
     * @param value value which will be associated with keys.
     */
    void put(K1 key1, K2 key2, V value);
}
