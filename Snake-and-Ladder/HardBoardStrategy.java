import java.util.*;

class HardBoardStrategy implements BoardGenerationStrategy {
    public Board generateBoard(int size, int count) {
        Map<Integer, Snake> snakes = new HashMap<>();
        Map<Integer, Ladder> ladders = new HashMap<>();

        Random rand = new Random();
        int max = size * size;

        Set<Integer> used = new HashSet<>();

while (snakes.size() < count) {
    int head = rand.nextInt(max / 2) + max / 2;
    int tail = rand.nextInt(head - 1) + 1;

    if (used.contains(head) || used.contains(tail)) continue;

    snakes.put(head, new Snake(head, tail));
    used.add(head);
    used.add(tail);
}

while (ladders.size() < count) {
    int start = rand.nextInt(max / 2) + 1;
    int end = start + rand.nextInt(max - start) + 1;

    if (used.contains(start) || used.contains(end) || end > max) continue;

    ladders.put(start, new Ladder(start, end));
    used.add(start);
    used.add(end);
}

        return new Board(size, snakes, ladders);
    }
}