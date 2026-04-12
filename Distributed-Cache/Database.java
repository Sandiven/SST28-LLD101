import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<String, String> db = new HashMap<>();

    public String get(String key) {
        return db.getOrDefault(key, "DB_VALUE_" + key);
    }

    public void put(String key, String value) {
        db.put(key, value);
    }
}