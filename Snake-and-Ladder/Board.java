import java.util.Map;

final class Board {
    private final int size;
    private final Map<Integer, Snake> snakes;
    private final Map<Integer, Ladder> ladders;

    public Board(int size, Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders) {
        this.size = size;
        this.snakes = Map.copyOf(snakes);
        this.ladders = Map.copyOf(ladders);
    }

    public int resolvePosition(int pos) {
       while (true) {
        if (snakes.containsKey(pos)) {
            pos = snakes.get(pos).getTail();
        } else if (ladders.containsKey(pos)) {
            pos = ladders.get(pos).getEnd();
        } else {
            break;
        }
    }
    return pos;
    }

    public int getEnd() {
        return size * size;
    }

    public int getSize() {
        return size;
    }
}