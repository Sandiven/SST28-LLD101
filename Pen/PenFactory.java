public class PenFactory {

    public static Pen getPen(String type, String color, String mechanismType) {

        WritingStrategy writingStrategy;
        RefillStrategy refillStrategy;
        MechanismStrategy mechanismStrategy;

        // Writing + Refill strategy
        switch (type.toLowerCase()) {
            case "ball":
                writingStrategy = new BallPenWriting();
                refillStrategy = new BallPenRefill();
                break;
            case "ink":
                writingStrategy = new InkPenWriting();
                refillStrategy = new InkPenRefill();
                break;
            case "gel":
                writingStrategy = new GelPenWriting();
                refillStrategy = new BallPenRefill(); // reuse if same logic
                break;
            default:
                throw new IllegalArgumentException("Invalid pen type");
        }

        // Mechanism
        switch (mechanismType.toLowerCase()) {
            case "with-cap":
                mechanismStrategy = new CapMechanism();
                break;
            case "click":
                mechanismStrategy = new ClickMechanism();
                break;
            default:
                throw new IllegalArgumentException("Invalid mechanism");
        }

        return new Pen(writingStrategy, refillStrategy, mechanismStrategy, color);
    }
}