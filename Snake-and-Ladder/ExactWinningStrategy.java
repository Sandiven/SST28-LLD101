class ExactWinningStrategy implements WinningStrategy {

    public boolean canMove(Player player, int roll, Board board) {
        return player.getPosition() + roll <= board.getEnd();
    }

    public boolean isWinner(Player player, Board board) {
        return player.getPosition() == board.getEnd();
    }
}