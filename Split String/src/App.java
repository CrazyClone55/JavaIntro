import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String userString;

        while (true) {
            System.out.print("gimme a word: ");
            userString = input.nextLine();
            if (userString.contains(" ")) {
                System.out.println("NO SPACES!");
            } else {
                input.close();
                break;
            }
        }

        if (userString.length() % 2 == 0){
            int splitPos = userString.length()/2;
            System.out.println(userString.substring(0, splitPos) + "-" + userString.substring(splitPos));
        } else {
            int splitPos1 = userString.length()/2;
            int splitPos2 = userString.length()/2 + 1;
            System.out.println(userString.substring(0, splitPos1) + "-" + userString.substring(splitPos1, splitPos2) + "-" + userString.substring(splitPos2));
        }
    }
}
