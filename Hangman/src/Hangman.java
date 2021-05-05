import java.util.Scanner;

public class Hangman {
    String answer;
    String answerBackup;
    String currentGuessed;
    String output;
    String previousGuesses = "";
    int amountIncorrectGuesses;
    Scanner inputScan = new Scanner(System.in);
    int guessStatus = 0;
    boolean continueGame = true;
    int previousGuessStatus = 4;

    public Hangman(String answer, User playerOne, User playerTwo) {
        //creates the variables and then replaces the letters with dashes, but not the spaces
        this.answer = answer;
        this.answerBackup = this.answer;
        this.output = this.answer;
        this.output = this.output.replaceAll("[^ ]", "_"); //regex
        this.startGame(playerOne, playerTwo);
        if (guessStatus == 1) {
            System.out.println("get wrecked, you lost... would you like to play again [Y/N]");
                String input = inputScan.nextLine();
            if (input.equals("Y")) {
                continueGame = true;
                return;
            } else {
                continueGame = false;
                return;
            }
            
        }
        if (guessStatus == 2) {
            System.out.println("You Won! would you like to play again? [Y/N]");
            String input = inputScan.nextLine();
            if (input.equals("Y")) {
                continueGame = true;
                return;
            } else {
                continueGame = false;
                return;
            }
        }
    }

    public void startGame(User playerOne, User playerTwo) {
        while (guessStatus == 0) {
            guess();
        }
        //if the guesser lost, give point to the person who came up with the word and switch players
        if (guessStatus == 1) {
            if (playerOne.getGuesser()) {
                playerTwo.setGuesser(true);
                playerOne.setGuesser(false);
                playerTwo.addPoint();
            } else if (playerTwo.getGuesser()) {
                playerOne.setGuesser(true);
                playerTwo.setGuesser(false);
                playerOne.addPoint();
            }
            return;
        //if the guesser won give point to the guesser and switch players
        } else if (guessStatus == 2) {
            if (playerOne.getGuesser()) {
                playerTwo.setGuesser(true);
                playerOne.setGuesser(false);
                playerOne.addPoint();
            } else if (playerTwo.getGuesser()) {
                playerOne.setGuesser(true);
                playerTwo.setGuesser(false);
                playerTwo.addPoint();
            }
            return;
        }
    }
    
    public void guess() {
        clearScreen();
        //outputs sentance based off of last answer
        if (previousGuessStatus == 0) {
            System.out.println("Sorry, no spaces or underscores allowed");
        } else if (previousGuessStatus == 1) {
            System.out.println("that has already been guessed, please try again!");
        } else if (previousGuessStatus == 2) {
            System.out.println("good guess");
        } else if (previousGuessStatus == 3) {
            System.out.println("incorrect guess");
        }
        printGame();
        //gets new letter
        System.out.println("please guess a letter or word");
        this.currentGuessed = inputScan.nextLine();
        if (this.currentGuessed.length() > 1) {
            if (this.currentGuessed.equals(answerBackup)) {
                this.guessStatus = 2;
                return;
            } else {
                this.previousGuessStatus = 3;
                this.amountIncorrectGuesses++;
                this.guessStatus = 0;
                return;
            }
        }
        //checks if letter is any of the prohibited characters
        if (this.currentGuessed.contains("_ ")) {
            this.previousGuessStatus = 0;
            this.guessStatus = 0;
            return;
        }
        //checks if the letter has been guessed before
        if (this.previousGuesses.contains(this.currentGuessed)) {
            //debug();
            this.previousGuessStatus = 1;
            this.guessStatus = 0; //status 0 means normal, guess again
            return;
        }
        //checks if the anser contains the letter
        if (this.answer.contains(this.currentGuessed)) {
            this.previousGuessStatus = 2;
            //adds the letter to the output to show you have guessed it
            while (this.answer.contains(this.currentGuessed)) {
                this.previousGuesses = this.previousGuesses.concat(this.currentGuessed);
                int position = this.answer.indexOf(this.currentGuessed);
                this.answer = this.answer.substring(0, position) + " "
                        + this.answer.substring(position + 1, this.answer.length());
                this.output = this.output.substring(0, position) + this.currentGuessed
                        + this.output.substring(position + 1, this.output.length());
            }
            //checks if you won
            if (checkGameStatus() == 1) {
                this.guessStatus = 2; //status 2 means you have won
                return;
            } else {
                this.guessStatus = 0;
                return;
            }
        //means you answered incoreectly, adds to the previous guesses and checks if you lost    
        } else {
            this.previousGuessStatus = 3;
            this.amountIncorrectGuesses++;
            this.previousGuesses = this.previousGuesses.concat(this.currentGuessed);
            if (checkGameStatus() == 2) {
                this.guessStatus = 1;
            }
            return;
        }
    }
    //checks if the output, the letters you have guessed correctly equals the backup of the answer because I have the original answer remove letters you have already guessed
    //so that the while loop back in the guess() method doesnt get stuck in an infinite loop
    public int checkGameStatus() {
        if (output.equals(answerBackup)) {
            return 1;
        } else if (amountIncorrectGuesses == 6) {
            return 2;
        } else {
            return 0;
        }
    }
    //prints out a different game board for each amount of incorrect guesses
    public void printGame() {
        if (amountIncorrectGuesses == 0) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (amountIncorrectGuesses == 1) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (amountIncorrectGuesses == 2) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println("  |   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (amountIncorrectGuesses == 3) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|   |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (amountIncorrectGuesses == 4) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println("      |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (amountIncorrectGuesses == 5) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" /    |");
            System.out.println("      |");
            System.out.println("=========");
        } else if (amountIncorrectGuesses == 6) {
            System.out.println("  +---+");
            System.out.println("  |   |");
            System.out.println("  O   |");
            System.out.println(" /|\\  |");
            System.out.println(" / \\  |");
            System.out.println("      |");
            System.out.println("=========");
        }





        System.out.println(output + "\n");
        System.out.println(previousGuesses);



    }

    public void debug() {
        System.out.println("answer: " + answer);
        System.out.println("current Guessed: " + currentGuessed);
        System.out.println("output: " + output);
        System.out.println("wrong guesses: " + previousGuesses);
        System.out.println("amount incorrect guesses: " + amountIncorrectGuesses);
        //System.out.println("guesser player: " + guesserPlayer);
        System.out.println("guess Status: " + guessStatus);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
