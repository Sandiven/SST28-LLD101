import java.util.*;

public class LRUEvictionPolicy implements EvictionPolicy {

    private final LinkedHashSet<String> set = new LinkedHashSet<>();

    @Override
    public void keyAccessed(String key) {
        set.remove(key);
        set.add(key);
    }

    @Override
    public String evictKey() {
        String oldest = set.iterator().next();
        set.remove(oldest);
        return oldest;
    }
}