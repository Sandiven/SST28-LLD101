public interface RateLimitStrategy {
    boolean allowRequest(String key, RateLimitConfig config);
}