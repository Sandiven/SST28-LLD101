public class CapMechanism implements MechanismStrategy {
    public void start() {
        System.out.println("Opening cap");
    }

    public void close() {
        System.out.println("Closing cap");
    }
}