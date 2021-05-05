import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Player One Name:");
        User playerOne = new User(scanner.nextLine());
        System.out.println("Player Two Name:");
        User playerTwo = new User(scanner.nextLine());

        playerOne.setGuesser(false);
        playerTwo.setGuesser(true);

        System.out.println(playerOne.getName() + ", please input a word to guess: ");
        Hangman hangman = new Hangman(scanner.nextLine(), playerOne, playerTwo);

        while (hangman.continueGame == true) {
            if (playerOne.getGuesser()){
                System.out.println(playerTwo.getName() + ", please input a word to guess: ");
            } else {
                System.out.println(playerOne.getName() + ", please input a word to guess: ");
            }
            hangman = new Hangman(scanner.nextLine(), playerOne, playerTwo);
        }
        if (hangman.continueGame == false) {
            System.out.println(playerOne.getName() + ": " + playerOne.getScore() + " points");
            System.out.println(playerTwo.getName() + ": " + playerTwo.getScore() + " points");
        }
    }
}