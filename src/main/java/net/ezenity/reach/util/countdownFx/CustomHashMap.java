package net.ezenity.reach.util.countdownFx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * CustomHashMap class is the Hash table based implementation of the Map interface. This class makes no
 * guarantees as to the iteration order of the map, in particular it does not guarantee that the order
 * will remain constant over time. This class also permits null keys and values.
 * <p>
 * @author anthonymmacallister
 * @version 1.0.0
 *
 * @param <K1> type of keys maintained by the map
 * @param <K2> type of keys maintained by the map
 * @param <V> type of mapped values
 */
public class CustomHashMap<K1, K2, V> {
    /**
     * HashMap object pairing both our keys for deep comparison to one value
     */
    private final HashMap<Pair<K1, K2>, V> hashMap;

    /**
     * Constructor initializing the capacity of the hash map to the given Map object
     */
    public CustomHashMap(){
        hashMap = new HashMap<Pair<K1, K2>, V>();
    }

    /**
     * Since we need to make sure that both our Keys are stored together this custom Pair class is created,
     * which uses a deep comparison to compare. This way we can create a HashMap with two Keys and one value.
     *
     * @param <K1> key object one
     * @param <K2> key object two
     */
    @SuppressWarnings("hiding")
    class Pair<K1, K2> {
        K1 key1;
        K2 key2;

        /**
         * Pair constructor, default super
         */
        Pair() {
            super();
        }

        /**
         * Creates a Pair Tuple.
         *
         * @param key1 key one
         * @param key2 key two
         */
        Pair(K1 key1, K2 key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        /**
         * Used to get the hash code value for this map
         *
         * @return the hash code value for this map
         */
        @Override
        public int hashCode() {
            return this.key1.hashCode() + this.key2.hashCode();
        }

        /**
         * Used to compare the specified Object with this Map for equality
         *
         * @param object to be compared for equality with this hash
         * @return 'true' if the specfieid Object is euqal to this Map
         */
        @Override
        public boolean equals(Object object){
            if (object == this)
                return true;
            if (!(object instanceof Pair))
                return false;
            @SuppressWarnings("unchecked")
            Pair<K1, K2> pair = (Pair<K1, K2>) object;
            if (this.key1.equals(pair.key1) && this.key2.equals(pair.key2))
                return true;
            return false;
        }
    }

    /**
     * Lets associated the specified value with the specified keys in this map
     *
     * @param key1 key one with which the specified value is to be associated
     * @param key2 key two with which the specified value is to be associated
     * @param value value to be associated with specified keys
     * @return the previous value associated with the keys, or null if there is no mapping for the keys
     */
    public V put(K1 key1, K2 key2, V value) {
        V previousValue = null;
        previousValue = this.hashMap.get(new Pair<K1, K2>(key1, key2));
        this.hashMap.put(new Pair<K1, K2>(key1, key2), value);
        return previousValue;
    }

    /**
     * Used to return the value which is specified to the specific mapped keys,or null if this map contains
     * no mapping for the keys.
     *
     * @param key1 key One whose associated value is to be returned
     * @param key2 key two whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public V get(K1 key1, K2 key2) {
        V value = null;
        value = this.hashMap.get(new Pair<K1, K2>(key1, key2));
        return value;
    }

    /**
     * Used to remove the mapping for the specified keys from this map if present.
     *
     * @param key1 key one whose mapping is to be removed from mapping
     * @param key2 key two whose mapping is to be removed from mapping
     * @return the previous value associated with key, or null if there was no mapping for the keys.
     */
    public V remove(K1 key1, K2 key2){
        V previousValue = null;
        previousValue = this.hashMap.get(new Pair<K1, K2>(key1, key2));
        this.hashMap.remove(new Pair<K1, K2>(key1, key2));
        return previousValue;
    }

    /**
     * Used to check if this map contains a mapping for the specified key.
     *
     * @param key1 key one whose presence in the mpa is t obe tested
     * @param key2 key two whose presence in the mpa is to be tested
     * @return 'true' if this map contains a mapping for the specified key
     */
    public boolean containsKey(K1 key1, K2 key2) {
        return this.hashMap.containsKey(new Pair<K1, K2>(key1, key2));
    }

    /**
     * Used to get a Set view of the keys contained in the map.
     *
     * @return a set view of the keys contained in the map
     */
    public Set<Pair<K1, K2>> keySet(){
        Set<Pair<K1, K2>> keySet;
        keySet = this.hashMap.keySet();
        return keySet;
    }

    /**
     * Used to return the number of key-value mappings on this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return this.hashMap.size();
    }

    /**
     * Used to iterator through the mappings to get the number of keys.
     *
     * @return an iterator over the keys in this deque
     */
    public Iterator<Pair<K1, K2>> iterator() {
        return this.keySet().iterator();
    }

    /**
     * Used to compute value for the given keys using the given mapping function, if the keys is not already
     * associated with a value (or is mapped to null) and enter that computed value in Hashmap else null.
     *
     * @param key1 key one for which we want to compute value using mapping
     * @param key2 key two for which we want to compute value using mapping
     * @param value function to do the operation on value
     * @return current (existing or computed) value associated with the specified keys, or null if mapping is null
     */
    public V computeIfAbsent(K1 key1, K2 key2, BiFunction<K1, K2, V> value) {
        return this.hashMap.computeIfAbsent(new Pair<K1, K2>(key1, key2), (k) -> value.apply(key1, key2));
    }

    /**
     * Used to get a string representation of this mapping object in the form of a set of entries.
     *
     * @return a string representation of the mapping
     */
    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder("{\n");
        Set<Pair<K1, K2>> keySet = this.keySet();
        Iterator<Pair<K1, K2>> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Pair<K1, K2> keyPair = (Pair<K1, K2>) iterator.next();
            stringBuffer.append("   [").append(keyPair.key1).append(", ").append(keyPair.key2).append("] = ").append(this.hashMap.get(new Pair<K1, K2>(keyPair.key1, keyPair.key2)));
            if (iterator.hasNext())
                stringBuffer.append(",\n");
        }
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }
}
