public class Main {

    public static void main(String[] args) throws InterruptedException {

        RateLimitConfig config = new RateLimitConfig(5, 60_000); // 5 req/min
        RateLimitKey key = new RateLimitKey("T1");

        // Using Fixed Window
        RateLimiter limiter = new RateLimiter(new FixedWindowStrategy());

        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allow(key, config);
            System.out.println("FixedWindow Request " + i + ": " + allowed);
        }

        // Switch to Sliding Window
        limiter.setStrategy(new SlidingWindowStrategy());

        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allow(key, config);
            System.out.println("SlidingWindow Request " + i + ": " + allowed);
        }
    }
}