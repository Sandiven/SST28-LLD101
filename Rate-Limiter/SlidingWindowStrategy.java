import java.util.*;

public class SlidingWindowStrategy implements RateLimitStrategy {

    private final Map<String, Deque<Long>> map = new HashMap<>();

    @Override
    public synchronized boolean allowRequest(String key, RateLimitConfig config) {
        long now = System.currentTimeMillis();

        map.putIfAbsent(key, new LinkedList<>());
        Deque<Long> queue = map.get(key);

        // Remove expired timestamps
        while (!queue.isEmpty() && now - queue.peekFirst() >= config.getWindowSizeInMillis()) {
            queue.pollFirst();
        }

        if (queue.size() < config.getMaxRequests()) {
            queue.addLast(now);
            return true;
        }

        return false;
    }
}