import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Gimme a year: ");
        Scanner input = new Scanner(System.in); //new scanner
        int inputYear = input.nextInt(); //get input
        input.close();

        if (inputYear % 4 == 0 && inputYear%100 != 0 || inputYear%400 == 0) { //modulus division to see if it is divisible by 4 and not divisible by 100 or if it is divisible by 400 (leap years are stupid)
            //year is a leap year
            System.out.println("The Year " + inputYear + " is a leap year");
        } else {
            //year is not a leap year
            System.out.println("The Year " + inputYear + " is not a leap year");
        }
    }
}
