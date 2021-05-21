import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        boolean repeat = true;
        int row;
        int col;
        //get row input
        do {
            System.out.println("Please enter a row: ");
            row = scan.nextInt()-1;
            if (row > 9 || row < 0) {
                System.out.println("Only numbers 1 - 8");
            } else {
                repeat = false;
            }
        } while (repeat == true);

        repeat=true;
        //get column input
        do {
            System.out.println("Please enter a column: ");
            col = scan.nextInt()-1;
            if (col > 9 || col < 0) {
                System.out.println("Only numbers 1 - 8");
            } else {
                repeat = false;
            }
        } while (repeat == true);

        String[][] board = new String[8][8];
        
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                board[r][c] = "[ ]";
            }
        }
        //horizontal and vertical lines
        for (int r = 0; r < 8; r++) {
            board[r][col] = "[X]";
        }
        for (int c = 0; c < 8; c++) {
            board[row][c] = "[X]";
        }
        board[row][col] = "[Q]";
        

        //diagonal lines
        int x = row;
        int y = col;        

        int x1 = x - 1;
        int y1 = y + 1;
        int x2 = x - 1;
        int y2 = y - 1;
        int x3 = x + 1;
        int y3 = y - 1;
        int x4 = x + 1;
        int y4 = y + 1;

        //goes out in all directions
        while (y1 < 8 && x1 >= 0) {
            board[x1][y1] = "[X]";
            x1--;
            y1++;
        }

        while (x2 >= 0 && y2 >= 0) {
            board[x2][y2] = "[X]";
            x2--;
            y2--;
        }

        while (x3 < 8 && y3 >= 0) {
            board[x3][y3] = "[X]";
            x3++;
            y3--;
        }

        while (x4 < 8 && y4 < 8) {
            board[x4][y4] = "[X]";
            x4++;
            y4++;
        }



        //print the board
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }
}
