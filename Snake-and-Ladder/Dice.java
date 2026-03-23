import java.util.*;
class Dice {
    private Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1;
    }
}