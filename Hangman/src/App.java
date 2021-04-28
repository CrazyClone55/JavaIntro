import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Player One Name and Character [John, O/X]:");
        User playerOne = new User(scanner.nextLine());
        System.out.println("Player Two Name and Character [Jane, O/X]:");
        User playerTwo = new User(scanner.nextLine());

        System.out.println(playerOne.getName() + "please input a word to guess: ");
        Hangman hangman = new Hangman(scanner.nextLine());


    }
}