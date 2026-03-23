import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size n: ");
        int n = sc.nextInt();

        System.out.print("Enter number of players: ");
        int x = sc.nextInt();

        System.out.print("Enter difficulty (easy/hard): ");
        String difficulty = sc.next();

        BoardGenerationStrategy boardStrategy = difficulty.equalsIgnoreCase("hard")
                ? new HardBoardStrategy()
                : new EasyBoardStrategy();

        Board board = boardStrategy.generateBoard(n, n);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= x; i++) {
            players.add(new Player("Player" + i));
        }

        System.out.print("Winning type (exact/fast): ");
        String winType = sc.next();

        WinningStrategy strategy = winType.equalsIgnoreCase("fast")
                ? new OvershootWinningStrategy()
                : new ExactWinningStrategy();

        Game game = new Game( board,players, strategy);
        game.start();
    }
}