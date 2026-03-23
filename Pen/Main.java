public class Main {
    public static void main(String[] args) {
        Pen pen = PenFactory.getPen("ink", "blue", "with-cap");

        pen.start();
        pen.write("Hello sir");
        pen.refill("black");
        pen.write("Writing");
        pen.close();
    }
}