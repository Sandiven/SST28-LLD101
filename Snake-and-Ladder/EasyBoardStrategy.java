import java.util.*;

class EasyBoardStrategy implements BoardGenerationStrategy {

    public Board generateBoard(int size, int count) {

        Map<Integer, Snake> snakes = new HashMap<>();
        Map<Integer, Ladder> ladders = new HashMap<>();
        Set<Integer> used = new HashSet<>();

        Random rand = new Random();
        int max = size * size;

       
        while (snakes.size() < count) {
            int head = rand.nextInt(max - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;

            if (used.contains(head) || used.contains(tail)) continue;

            Snake snake = new Snake(head, tail);
            snakes.put(head, snake);

            used.add(head);
            used.add(tail);
        }

       
        while (ladders.size() < count) {
            int start = rand.nextInt(max - 1) + 1;
            int end = rand.nextInt(max - start) + start + 1;

            if (used.contains(start) || used.contains(end)) continue;

            Ladder ladder = new Ladder(start, end);
            ladders.put(start, ladder);

            used.add(start);
            used.add(end);
        }

        return new Board(size, snakes, ladders);
    }
}