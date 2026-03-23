interface WinningStrategy {
    boolean canMove(Player player, int roll, Board board);
    boolean isWinner(Player player, Board board);
}