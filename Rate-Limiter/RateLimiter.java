public class RateLimiter {

    private RateLimitStrategy strategy;

    public RateLimiter(RateLimitStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RateLimitStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allow(RateLimitKey key, RateLimitConfig config) {
        return strategy.allowRequest(key.getKey(), config);
    }
}