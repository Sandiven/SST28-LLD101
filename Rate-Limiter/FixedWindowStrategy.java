import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowStrategy implements RateLimitStrategy {

    private static class Window {
        long windowStart;
        int count;

        Window(long start) {
            this.windowStart = start;
            this.count = 0;
        }
    }

    private final ConcurrentHashMap<String, Window> map = new ConcurrentHashMap<>();

    @Override
    public synchronized boolean allowRequest(String key, RateLimitConfig config) {
        long currentTime = System.currentTimeMillis();

        map.putIfAbsent(key, new Window(currentTime));
        Window window = map.get(key);

        if (currentTime - window.windowStart >= config.getWindowSizeInMillis()) {
            window.windowStart = currentTime;
            window.count = 0;
        }

        if (window.count < config.getMaxRequests()) {
            window.count++;
            return true;
        }

        return false;
    }
}