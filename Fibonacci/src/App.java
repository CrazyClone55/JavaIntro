import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int input;
        int num1 = 1;
        int num2 = 0;
        int num3;
        System.out.print("Input a number:");
        input = scan.nextInt();
        //if input is zero output only zero
        if (input == 0) {
            System.out.print("0");
            System.exit(0);
        }
        System.out.print("0");
        do {
            
            num3 = num1 + num2; // add previous numer
            //move previous numbers up one step
            num1 = num2;
            num2 = num3;
            input--;
            System.out.print(", "+num3);
        } while (input >= 1);
    }
}
