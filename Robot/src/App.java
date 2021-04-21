public class App {
    public static void main(String[] args) throws Exception {
        Robot sam = new Robot("Sam");
        sam.setDirection(0);
        sam.setSpeed(10);
        sam.moveForward();
        sam.printLocation();
        sam.setDirection(135);
        sam.setSpeed(3);
        sam.moveForward();
        sam.moveForward();
        sam.printLocation();

        Robot jo = new Robot("Jo", -10, 2, 2, 135);
        jo.printLocation();
        jo.moveForward();
        jo.moveForward();
        jo.printLocation();
        jo.setDirection(90);
        jo.moveForward();
        jo.printLocation();
        System.out.println(jo.distanceTo(sam));
    }
}
