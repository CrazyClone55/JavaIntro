// Program to convert Roman
// Numerals to Numbers
import java.util.*;

public class App
{
    public static void main(String args[])
	{
		ConvertToInt obj = new ConvertToInt();

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Please enter a Roman Numeral: ");
        String numeralOne = scanner.next();

        System.out.print("Please enter another Roman Numeral: ");
        String numeralTwo = scanner.next();

        scanner.close();

        
        int numberOne = obj.convert(numeralOne);
        int numberTwo = obj.convert(numeralTwo);



        int total = numberOne + numberTwo;

        String totalRoman = "ihu";

        System.out.println(numeralOne + " + " + numeralTwo + " = " + totalRoman);
        System.out.println(numberOne + " + " + numberTwo + " = " + total);
	}
}