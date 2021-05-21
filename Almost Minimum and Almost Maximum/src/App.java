import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int arraySize;
        int inputValue;
        int[] dataSet;

        //gets smallest and largest values possible that way it can compare any possible int
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        Scanner scan = new Scanner(System.in);
        System.out.println("input array size");

        arraySize = scan.nextInt();
        dataSet = new int[arraySize];

        //get array values
        for (int i = 0; i < dataSet.length; i++) {
            System.out.println("input array value, spot [" + i + "]");
            inputValue = scan.nextInt();
            dataSet[i] = inputValue;
        }

        //find largest num
        for (int num : dataSet) {
            //if the largest is smaller that means it isnt the smallest
            if (firstLargest < num) {
                //passes the value to the second largest
                secondLargest = firstLargest;
                //and gets new value
                firstLargest = num;
            //only gets here if the value is inbetween the largest and second largest
            } else if (secondLargest < num) {
                //gets new second largest value
                secondLargest = num;
            }
        }
        
        //find smallest num
        for (int num : dataSet) {
            //if the smallest is larger that means it isnt the smallest
            if (firstSmallest > num) {
                //passes the value to the second smallest
                secondSmallest = firstSmallest;
                //and gets the smaller value
                firstSmallest = num;
                //only gets here if the value is inbetween the smallest and second smallest    
            } else if (secondSmallest > num) {
                //gets new second smallest value
                secondSmallest = num;
            }
        }
        
       
        System.out.print("[");
        for (int k = 0; k < dataSet.length; k++) {
            if (k != dataSet.length - 1) {
                System.out.print(dataSet[k] + ", ");
            } else {
                System.out.print(dataSet[k] + "]\n");
            }
        }
        System.out.println("The 2nd smallest integer is: " + secondSmallest + "\nThe 2nd largest integer is: " + secondLargest);
    }
}

