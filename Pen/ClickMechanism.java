public class ClickMechanism implements MechanismStrategy {
    public void start() {
        System.out.println("Clicking pen ON");
    }

    public void close() {
        System.out.println("Clicking pen OFF");
    }
}