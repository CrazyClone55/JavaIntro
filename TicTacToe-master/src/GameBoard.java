import java.util.Scanner;

public class GameBoard {
    String row0;
    String row1;
    String row2;

    int locationState = 3;

    String lineBreak;

    Boolean retryStatus = false;

    int turn = 1;
   


    public GameBoard() {
        this.row0 = "|   |   |   |";
        this.row1 = "|   |   |   |";
        this.row2 = "|   |   |   |";
        this.lineBreak = "-------------";
    }

    public void move(String[] location, User player) {
        if (location[0].equals("1")) {
            if (location[1].equals("1")) {
                if (row0.charAt(2) == ' ') {
                    row0 = row0.substring(0, 2) + player.getSymbol() + row0.substring(3, row0.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else if (location[1].equals("2")) {
                if (row0.charAt(6) == ' ') {
                    row0 = row0.substring(0, 6) + player.getSymbol() + row0.substring(7, row0.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else if (location[1].equals("3")) {
                if (row0.charAt(10) == ' ') {
                    row0 = row0.substring(0, 10) + player.getSymbol() + row0.substring(11, row0.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else {
            locationState = 2;
            }
        } else if (location[0].equals("2")) {
            if (location[1].equals("1")) {
                if (row1.charAt(2) == ' ') {
                    row1 = row1.substring(0, 2) + player.getSymbol() + row1.substring(3, row1.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else if (location[1].equals("2")) {
                if (row1.charAt(6) == ' ') {
                    row1 = row1.substring(0, 6) + player.getSymbol() + row1.substring(7, row1.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else if (location[1].equals("3")) {
                if (row1.charAt(10) == ' ') {
                    row1 = row1.substring(0, 10) + player.getSymbol() + row1.substring(11, row1.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else {
            locationState = 2;
            }
        } else if (location[0].equals("3")) {
            if (location[1].equals("1")) {
                if (row2.charAt(2) == ' ') {
                    row2 = row2.substring(0, 2) + player.getSymbol() + row2.substring(3, row2.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else if (location[1].equals("2")) {
                if (row2.charAt(6) == ' ') {
                    row2 = row2.substring(0, 6) + player.getSymbol() + row2.substring(7, row2.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else if (location[1].equals("3")) {
                if (row2.charAt(10) == ' ') {
                    row2 = row2.substring(0, 10) + player.getSymbol() + row2.substring(11, row2.length());
                    locationState = 0;
                } else {
                    locationState = 1;
                }
            } else {
            locationState = 2;
            }
        } else {
            locationState = 2;
        }
    }

    public String checkBoard() {
        char winningSymbol;

        //if statements checking rows
        if (row0.charAt(2) == row0.charAt(6) && row0.charAt(10) == row0.charAt(6) && row0.charAt(2) != ' ') {
            winningSymbol = row0.charAt(2);
            return Character.toString(winningSymbol);
        } else if (row1.charAt(2) == row1.charAt(6) && row1.charAt(10) == row1.charAt(6) && row1.charAt(2) != ' ') {
            winningSymbol = row1.charAt(2);
            return Character.toString(winningSymbol);
        } else if (row2.charAt(2) == row2.charAt(6) && row2.charAt(10) == row2.charAt(6) && row2.charAt(2) != ' ') {
            winningSymbol = row2.charAt(2);
            return Character.toString(winningSymbol);
        } else if (row0.charAt(2) == row1.charAt(2) && row1.charAt(2) == row2.charAt(2) && row0.charAt(2) != ' ') {//if statements checking columns
            winningSymbol = row0.charAt(2);
            return Character.toString(winningSymbol);
        } else if (row0.charAt(10) == row1.charAt(10) && row1.charAt(10) == row2.charAt(10) && row0.charAt(10) != ' '){
            winningSymbol = row0.charAt(10);
            return Character.toString(winningSymbol);
        } else if (row0.charAt(6) == row1.charAt(6) && row1.charAt(6) == row2.charAt(6) && row0.charAt(6) != ' '){
            winningSymbol = row0.charAt(6);
            return Character.toString(winningSymbol);
        } else if (row0.charAt(2) == row1.charAt(6) && row1.charAt(6) == row2.charAt(10) && row0.charAt(2) != ' '//if statement checking diagonal
                || row0.charAt(10) == row1.charAt(6) && row1.charAt(6) == row2.charAt(2) && row0.charAt(10) != ' ') {
            winningSymbol = row1.charAt(6);
            return Character.toString(winningSymbol);
        } else if (row0.chars().filter(ch -> ch == 'X').count()+row0.chars().filter(ch -> ch == 'O').count()+
                    row1.chars().filter(ch -> ch == 'X').count()+row1.chars().filter(ch -> ch == 'O').count()+
                    row2.chars().filter(ch -> ch == 'X').count()+row2.chars().filter(ch -> ch == 'O').count() == 9) {
            return "T";
        } else {
            return "C";
        }
    }

    public void printBoard() {
        System.out.println(row0);  
        System.out.println(lineBreak);
        System.out.println(row1);  
        System.out.println(lineBreak);
        System.out.println(row2);
    }
    
    public String prompt(User player) {
        System.out.print("\033\143");
        this.printBoard();
        if (retryStatus == true) {
            System.out.println("Your last response was wrong, try again");
            retryStatus = false;
        }
        System.out.print(player.name + ", please pick a move formatted as following [1, 2]");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if (input.length() < 4) {
            retryStatus = true;
            input = "";
            return "";
        }

        String loc1 = input.substring(0, 1);
        String loc2 = input.substring(3, 4);

        String[] location = { loc1, loc2 };

        this.move(location, player);

        if (locationState == 1) {
            retryStatus = true;
            return "";
        }
        if (locationState == 2) {
            retryStatus = true;
            return "";
        }

        if (turn == 1) {
            turn = 2;
        } else if (turn == 2) {
            turn = 1;
        }
        return checkBoard();
    }
    
    public void checkResponse(String result, User playerOne, User playerTwo) {
        if (result.equals("X") || result.equals("O")) {
            System.out.print("\033\143");
            this.printBoard();
            if (playerOne.getSymbol().equals(result)) {
                    System.out.println("Congrats! " + playerOne.getName() + " has won!");
                    System.exit(0);
                } else if (playerTwo.getSymbol().equals(result)) {
                    System.out.println("Congrats! " + playerTwo.getName() + " has won!");
                    System.exit(0);
                }
        } else if (result.equals("T")) {
                System.out.print("\033\143");
                this.printBoard();
                System.out.println("Cat won the game, better luck next time!");
                System.exit(0);
        }
    }
    
    public void startGame(User playerOne, User playerTwo) {
        String result;
        while (turn == 1) {
            result = this.prompt(playerOne);
            this.checkResponse(result, playerOne, playerTwo);
            System.out.println("restarting");
        }
        while (turn == 2){
            result = this.prompt(playerTwo);
            this.checkResponse(result, playerOne, playerTwo);
            System.out.println("restarting");
        }
        this.startGame(playerOne, playerTwo);
    }
}
