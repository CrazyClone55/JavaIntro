import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int arraySize;
        double inputValue;
        double[] dataSet;
        boolean continueSearch = true;
        double searchValue;
        int firstPosition = -1;
        int lastPosition = -2;

        Scanner scan = new Scanner(System.in);
        System.out.println("input array size");

        arraySize = scan.nextInt();
        dataSet = new double[arraySize];//update array size
        //loop to fill array with user inputs
        for (int i = 0; i < dataSet.length; i++) {
            System.out.println("input array value, spot [" + i + "]");
            inputValue = scan.nextDouble();
            dataSet[i] = inputValue;
        }

        //ask for value to search
        while (continueSearch == true) {
            System.out.println("input value to search for");
            searchValue = scan.nextDouble();
            //check the array first to last value for the user value
            for (int i = 0; i < dataSet.length; i++) {
                //if position [i] has the value
                if (dataSet[i] == searchValue) {
                    firstPosition = i;
                    i = dataSet.length;//this stops the for loop from running again since if found the value already
                    //searches last to first value
                    for (int j = dataSet.length - 1; j >= 0; j--) {
                        if (dataSet[j] == searchValue) {
                            lastPosition = j;
                            j = 0;//this stops the for loop from running, same reason as before
                        }
                    }
                }
            }
            //if it found a value
            if (firstPosition != -1) {
                //print out the array
                System.out.print("[");
                for (int k = 0; k < dataSet.length; k++) {
                    if (k != dataSet.length - 1) {
                        System.out.print(dataSet[k] + ", ");
                    } else {
                        System.out.print(dataSet[k] + "]\n");
                    }
                }
                //print out the index locations
                System.out.println("The first index " + searchValue + " is located at is " + firstPosition);
                System.out.println("The last index " + searchValue + " is located at is " + lastPosition);
            } else {//if it doesnt have a value, print that it couldn't find it
                System.out.println(
                        "The value " + searchValue + " that you searched for is not contained within the array");
            }
            //ask to search again
            System.out.println("Would you like to search for another value? [Y/N]");
            if (scan.next().equals("Y")) {
                continueSearch = true;
            } else {
                System.exit(0);
            }
        }

    }
}