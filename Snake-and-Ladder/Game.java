import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Game {
    private Board board;
    private Queue<Player> players;
    private Dice dice;
    private WinningStrategy winningStrategy;

    public Game(Board board, List<Player> players, WinningStrategy winningStrategy) {
        this.board = board;
        this.players = new LinkedList<>(players);
        this.dice = new Dice();
        this.winningStrategy = winningStrategy;
    }
    public void start() {
        int end = board.getEnd();
        while(players.size() > 1) {
            Player player = players.poll();

            int roll = dice.roll();
           

            if (!winningStrategy.canMove(player, roll, board)) {
                players.offer(player);
                continue;
            }
             int newPos = player.getPosition() + roll;
            newPos = board.resolvePosition(newPos);
            player.setPosition(newPos);

            if (winningStrategy.isWinner(player, board)) {
                System.out.println(player.getName() + " wins!");
                continue;
            }

            players.offer(player);
        }
        System.out.println("Game Over!");
    }
}