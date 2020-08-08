package net.ezenity.reach.util.countdownFx;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class CustomMap<K1, K2, V> implements Timer<K1, K2, V> {
    private final Map<K1, V> MAP1 = new HashMap<>();
    private final Map<K2, V> MAP2 = new HashMap<>();

    @Override
    public Map<K1, V> getMap1() {
        return Collections.unmodifiableMap(MAP1);
    }

    @Override
    public Map<K2, V> getMap2() {
        return Collections.unmodifiableMap(MAP2);
    }

    @Override
    public void put(K1 key1, K2 key2, V value) {
        MAP1.put(key1, value);
        MAP2.put(key2, value);
    }
}
