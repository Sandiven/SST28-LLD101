public class BallPenRefill implements RefillStrategy {
    public void refill(String color) {
        System.out.println("Refilling ball pen with " + color + " ink");
    }
}