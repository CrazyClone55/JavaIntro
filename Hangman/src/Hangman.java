import java.util.Scanner;

public class Hangman {
    String answer;
    String currentGuessed;
    String output;
    String wrongGuesses;
    int amountIncorrectGuesses;
    int guesserPlayer;
    Scanner inputScan = new Scanner(System.in);
    int guessStatus = 0;

    public Hangman(String answer) {
        if (answer.contains(" ")) {
            this.answer = answer;
            this.output = this.answer;
            this.output = this.output.replaceAll(" ", "~");
            this.output = this.output.replaceAll("[^ ]", "");
        } else {
            this.answer = answer;
            this.output = "_".repeat(this.answer.length());
        }
        this.startGame();
    }

    public void startGame() {

        while (guessStatus == 0) {
            guess();
        }
        if (guessStatus == 1) {
            
        } else if (guessStatus == 2) {
            
        }
    }
    
    public void guess() {
        //TODO pritn out the board
        System.out.println("please guess a letter");
        currentGuessed = inputScan.nextLine();
        if (wrongGuesses.contains(currentGuessed)) {
            System.out.println("that has already been guessed, please try again!");
            guessStatus = 0;
            return;
        }
        if (this.answer.contains(currentGuessed)) {
            System.out.println("good guess");
            while (this.answer.contains(currentGuessed)){
                this.output = this.output this.answer.indexOf(currentGuessed);
            }
        }
    }

    public String checkGuess() {
        return "";
    }
    
    public void checkGameStatus() {

    }
    
    public void displayGameStatus() {

    }
    

}
