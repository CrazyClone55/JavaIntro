import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int dataSet[];
        int inputValue;
        Scanner scan = new Scanner(System.in);
        int arraySize;
        int targetValue;
        ArrayList<String> equationsAdd = new ArrayList<String>();
        ArrayList<String> equationsSubtract = new ArrayList<String>();
        //ArrayList<String> firstNum = new ArrayList<String>();
        //ArrayList<String> secondNum = new ArrayList<String>();
        
        System.out.println("input array size");
        
        arraySize = scan.nextInt();

        dataSet = new int[arraySize];//update array size
        //loop to fill array with user inputs
        for (int i = 0; i < dataSet.length; i++) {
            System.out.println("input array value, spot [" + i + "]");
            inputValue = scan.nextInt();
            dataSet[i] = inputValue;
        }

        System.out.println("input target value");
        targetValue = scan.nextInt();

        //for each number in the dataset
        for (int num : dataSet) {
            //if it is greater than or equal to the target it means the only way is to subtract something
            if (num >= targetValue) {
                //for each value, test it against all other values
                for (int num1 : dataSet) {
                    //if it equals the target, add the equation to the arraylist
                    if (num - num1 == targetValue) {
                        equationsSubtract.add(num + " - " + num1 + " = " + targetValue);
                    }
                }
            //if it is less than or equal to the target it means the only way is to add something    
            } else if (num <= targetValue) {
                //for each value, test it against all other values 
                for (int num2 : dataSet) {
                    //if it equals the target add the equation to the arraylist
                    if (num + num2 == targetValue) {
                        equationsAdd.add(num + " + " + num2 + " = " + targetValue);
                    }
                }

            }
        }
        
        //check if there were any possible solutions
        if (equationsAdd.isEmpty()||equationsSubtract.isEmpty()) {
            System.out.println("There are no ways to add or subtract to equal " + targetValue);
        } else {

            //ignore this, failed attempt at making it remove opposite addition equations
            /*
            for (String equation : equationsAdd) {
                firstNum.add(String.valueOf(equation.charAt(0)));
                secondNum.add(String.valueOf(equation.charAt(4)));
            }
            
            for (String num: firstNum){
                int pos = secondNum.indexOf(num);
                //System.out.println(pos + num);
                if (pos != -1) {
                    if (firstNum.get(pos).equals(secondNum.get(firstNum.indexOf(num)))) {
                        int index = equationsAdd
                                .indexOf(num + " + " + secondNum.get(firstNum.indexOf(num)) + " = " + targetValue);
                        equationsAdd.remove(index);
                    }
                }
            }*/
            



            //combine the 2 lists
            equationsAdd.addAll(equationsSubtract);
            //print out all of the equations
            for (String equation : equationsAdd) {
                System.out.println(equation);
            }
        }
    }
}
