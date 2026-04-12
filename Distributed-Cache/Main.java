public class Main {

    public static void main(String[] args) {

        Database db = new Database();

        DistributedCache cache = new DistributedCache(
                3,
                2,
                new ModuloDistributionStrategy(),
                db
        );

        System.out.println(cache.get("A"));
        System.out.println(cache.get("A")); // cache hit

        cache.put("B", "Hello");
        System.out.println(cache.get("B"));

        cache.put("C", "World");
        cache.put("D", "Eviction Test");

        System.out.println(cache.get("C"));
    }
}