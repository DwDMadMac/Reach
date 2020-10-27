package net.ezenity.reach.Fx.countdown;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom Map. This custom map will allow you to create two keys with one value. The way this
 * is implemented is we put each key into its own map of collections which will allow us
 * to look up these individual keys if need be. However, there is a downside to this. when putting
 * the keys into the map this will apply a duplicate of the value. Key One will have the same value as Key Two.
 *
 * @author Ezenity
 * @version 1.0.0
 * @since 1.0.0
 *
 * @param <K1> set a key to the map
 * @param <K2> set a key to the map
 * @param <V> return the same value for both key one and two.
 */
public final class CustomMap<K1, K2, V> implements Timer<K1, K2, V> {
    /**
     * Map one. Create a hashmap with key one. The value will equal same value as Map two.
     */
    private final Map<K1, V> MAP1 = new HashMap<>();
    /**
     * Map one. Create a hashmap with key two. The value will equal same value as Map one.
     */
    private final Map<K2, V> MAP2 = new HashMap<>();

    /**
     * Get map one. This will return a map that is for viewing purposes only. This will prevent
     * any unwanted changes to the given value with map one. This allows us to key map one and
     * two in sync with each other.
     *
     * @return viewable modifiable map value.
     */
    @Override
    public Map<K1, V> getMap1() {
        return Collections.unmodifiableMap(MAP1);
    }

    /**
     * Get map two. This will return a map that is for viewing purposes only. This will prevent
     * any unwanted changes to the given value with map two. This allows us to key map two and
     * one in sync with each other.
     *
     * @return viewable modifiable map value.
     */
    @Override
    public Map<K2, V> getMap2() {
        return Collections.unmodifiableMap(MAP2);
    }

    /**
     * This method will associate the value with the specified key one and key two.
     *
     * @param key1 key one which the specified value is to be associated with.
     * @param key2 key one which the specified value is to be associated with
     * @param value value associated with the specified keys
     */
    @Override
    public void put(K1 key1, K2 key2, V value) {
        MAP1.put(key1, value);
        MAP2.put(key2, value);
    }
}
