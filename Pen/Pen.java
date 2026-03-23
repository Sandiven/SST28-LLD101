public class Pen {
    private WritingStrategy writingStrategy;
    private RefillStrategy refillStrategy;
    private MechanismStrategy mechanismStrategy;

    private String color;
    private boolean isStarted = false;

    public Pen(WritingStrategy writingStrategy,
               RefillStrategy refillStrategy,
               MechanismStrategy mechanismStrategy,
               String color) {
        this.writingStrategy = writingStrategy;
        this.refillStrategy = refillStrategy;
        this.mechanismStrategy = mechanismStrategy;
        this.color = color;
    }

    public void start() {
        mechanismStrategy.start();
        isStarted = true;
    }

    public void close() {
        mechanismStrategy.close();
        isStarted = false;
    }

    public void write(String text) {
        if (!isStarted) {
            throw new IllegalStateException("Pen must be started before writing!");
        }
        writingStrategy.write(text, color);
    }

    public void refill(String newColor) {
        this.color = newColor;
        refillStrategy.refill(newColor);
    }
}