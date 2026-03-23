public class InkPenRefill implements RefillStrategy {
    public void refill(String color) {
        System.out.println("Refilling ink pen with " + color);
    }
}