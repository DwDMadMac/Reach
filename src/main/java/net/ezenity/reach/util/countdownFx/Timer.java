package net.ezenity.reach.util.countdownFx;


import java.util.Map;

/**
 * Timer abstract class for creating custom countdowns, timers, cooldowns.
 */
public interface Timer<K1, K2, V> {
    Map<K1, V> getMap1();
    Map<K2, V> getMap2();
    void put(K1 key1, K2 key2, V value);
}
