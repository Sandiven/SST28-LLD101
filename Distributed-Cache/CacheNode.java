import java.util.HashMap;
import java.util.Map;

public class CacheNode {

    private final int capacity;
    private final Map<String, CacheValue> map;
    private final EvictionPolicy evictionPolicy;

    public CacheNode(int capacity, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.map = new HashMap<>();
    }

    public synchronized String get(String key) {
        if (!map.containsKey(key)) return null;

        evictionPolicy.keyAccessed(key);
        return map.get(key).getValue();
    }

    public synchronized void put(String key, String value) {
        if (map.containsKey(key)) {
            map.put(key, new CacheValue(value));
            evictionPolicy.keyAccessed(key);
            return;
        }

        if (map.size() >= capacity) {
            String evict = evictionPolicy.evictKey();
            map.remove(evict);
        }

        map.put(key, new CacheValue(value));
        evictionPolicy.keyAccessed(key);
    }
}