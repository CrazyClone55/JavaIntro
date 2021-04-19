import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //create scanner
        Scanner input = new Scanner(System.in);

        //initializing variables
        int[] digits = {2, 4, 6, 8, 10};
        int runNum = 0;
        char[] digitsString = {1, 1, 1, 1, 1};

        //get input
        int number = input.nextInt();

        //clone input for outputing
        Integer numberOriginal = number;

        //close scanner
        input.close();

        //loop to write digits to a array in number form
        while (number > 0) {
            int remainder  = number % 10;
            number = number / 10;
            digits[runNum] = remainder;
            runNum++;
        }

        //convert the number to a string
        String numberString = numberOriginal.toString();

        //loop to get the character at each location
        for (int i = 0; i < numberString.length(); i++) {
            digitsString[i] = numberString.charAt(i);
          }

        //output of using modulus division
        System.out.println("The 5 digit number input was " + numberOriginal);
        System.out.println("The 1st digit is: " + digits[4]);
        System.out.println("The 2nd digit is: " + digits[3]);
        System.out.println("The 3st digit is: " + digits[2]);
        System.out.println("The 4th digit is: " + digits[1]);
        System.out.println("The 5th digit is: " + digits[0]);

        //output of using string method
        System.out.println("The 5 digit number input was " + numberOriginal);
        System.out.println("The 1st digit is: " + digitsString[0]);
        System.out.println("The 2nd digit is: " + digitsString[1]);
        System.out.println("The 3st digit is: " + digitsString[2]);
        System.out.println("The 4th digit is: " + digitsString[3]);
        System.out.println("The 5th digit is: " + digitsString[4]);



    }
}
