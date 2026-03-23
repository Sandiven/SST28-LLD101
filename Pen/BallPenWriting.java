public class BallPenWriting implements WritingStrategy {
    public void write(String text, String color) {
        System.out.println("Ball pen writing in " + color + ": " + text);
    }
}