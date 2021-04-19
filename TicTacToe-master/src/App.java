import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        User playerOne = new User();
        User playerTwo = new User();

        GameBoard gameBoard = new GameBoard();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player One Name and Character [John, O/X]:");
        String input1 = scanner.nextLine();
        playerOne.init(input1.split(", "));
        System.out.println("Player Two Name and Character [Jane, O/X]:");
        String input2 = scanner.nextLine();
        playerTwo.init(input2.split(", "));

        if (!playerOne.getSymbol().equals("X") && !playerOne.getSymbol().equals("O")) {
            System.out.println("wrong symbols!(playerOne)");
            System.exit(0);
        }
        if (!playerTwo.getSymbol().equals("X") && !playerTwo.getSymbol().equals("O")) {
            System.out.println("wrong symbols!(playerTwo)");
            System.exit(0);
        }
        if (playerOne.symbol == playerTwo.symbol) {
            System.out.println("no two same symbols");
            System.exit(0);
        }


        gameBoard.startGame(playerOne, playerTwo);

    }
}