public class GelPenWriting implements WritingStrategy {
    public void write(String text, String color) {
        System.out.println("Gel pen writing thick in " + color + ": " + text);
    }
}