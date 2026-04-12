import java.util.ArrayList;
import java.util.List;

public class DistributedCache implements Cache {

    private final List<CacheNode> nodes;
    private final DistributionStrategy strategy;
    private final Database database;

    public DistributedCache(int numNodes, int capacityPerNode,
                            DistributionStrategy strategy,
                            Database database) {

        this.nodes = new ArrayList<>();
        this.strategy = strategy;
        this.database = database;

        for (int i = 0; i < numNodes; i++) {
            nodes.add(new CacheNode(capacityPerNode, new LRUEvictionPolicy()));
        }
    }

    @Override
    public String get(String key) {
        CacheNode node = strategy.getNode(key, nodes);

        String value = node.get(key);
        if (value != null) return value;

        // Cache miss
        value = database.get(key);
        node.put(key, value);

        return value;
    }

    @Override
    public void put(String key, String value) {
        CacheNode node = strategy.getNode(key, nodes);

        node.put(key, value);
        database.put(key, value); // assumption: write-through
    }
}