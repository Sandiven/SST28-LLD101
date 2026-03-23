public class InkPenWriting implements WritingStrategy {
    public void write(String text, String color) {
        System.out.println("Ink pen flowing smoothly in " + color + ": " + text);
    }
}