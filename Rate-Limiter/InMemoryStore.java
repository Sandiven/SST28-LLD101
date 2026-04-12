import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStore {
    private static final ConcurrentHashMap<String, Object> store = new ConcurrentHashMap<>();

    public static Object get(String key) {
        return store.get(key);
    }

    public static void put(String key, Object value) {
        store.put(key, value);
    }
}