import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int length = 1;
        String output;
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a number");
        int width = scan.nextInt();
        scan.close();
        if (width % 2 == 0) {
            System.out.println("please enter a odd number next time");
            System.exit(1);
        }

        for (int i = width / 2 + 1; i > 0; i--) {
            output = "*".repeat(length);
            //System.out.print(length);
            System.out.println(output);
            length++;
        }

        for (int i = width / 2; i > 0; i--) {
            length = i;
            output = "*".repeat(length);
            //System.out.print(length);
            System.out.println(output);
        }
    }
}
