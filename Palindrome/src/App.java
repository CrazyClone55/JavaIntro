import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //variables
        Scanner input = new Scanner(System.in);
        String wordIn;
        int length;
        int forward = 0;
        int backward;
        char forwardChar;
        char backwardChar;
        boolean palinromeStatus = true;
        //ask for input
        System.out.println("Please provide a word to check for palindrome");
        //make input to lowercase
        wordIn = input.next().toLowerCase();
        //get length
        length = wordIn.length();
        //get position for backward character
        backward = length - 1;
        //while loop that checks if it is a palindrome, it is assumed that it is the first run through but changed if it is not
        while (palinromeStatus == true) {
            //second while loop that iterates through every character
            while (backward > forward) {
                //get the forward charater and iterate the position 1 up
                forwardChar = wordIn.charAt(forward++);
                //get the backward character and iterate the position 1 down
                backwardChar = wordIn.charAt(backward--);
                //System.out.println(palinromeStatus);
                //System.out.println(forwardChar);
                //System.out.println(backwardChar);
                //check if the two characters are not equal and set palindromeStatus to false telling the the exterior loop to exit once the interior one is done going through all the characters
                if (forwardChar != backwardChar) {
                    palinromeStatus = false;
                }
            }
            //checks palindrome status, only checks after each character has been checked that way it relfects the entire word rather than just one position
            if (palinromeStatus == true) {
                System.out.println("The given word \"" + wordIn + "\" is a palindrome");
                System.exit(0);
            }
        }
        //if statement is redundant, only possible outcome now is that it is not a palindrome
        if (palinromeStatus == false) {
            System.out.println("The given word \"" + wordIn + "\" is not a palindrome");
            System.exit(0);
        }
    }
}
