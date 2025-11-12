import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        //Create a 3x3 board
        char board[][] = new char[3][3];

        Scanner sc = new Scanner(System.in);

        //Initialize the board as empty spaces
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++ ) {
                board[row][col] = ' ';
            }
        }

        //Initialize current player
        char player;
        while(true) {
            System.out.print("Choose the first player(X or O): ");
            player = sc.next().charAt(0);
            if(player != 'X' && player != 'O') {
                System.out.println("Invalid input! Please try again...");
            }
            else break;
        }
        //Game is NOT over
        boolean gameOver = false;

        //Loop runs as long as the game is NOT over
        while(!gameOver) {
            printBoard(board);

            //Take input for position where the player wants to play
            System.out.println("Player "+player+" enter the position: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            //Fill the position only if it is empty
            if(board[row][col] == ' ') {
                board[row][col] = player;

                //Check if the game is over or not after every move
                gameOver = haveWon(board, player);

                //Display the winner if the game is over, else switch players
                if(gameOver) System.out.println("Player "+player+" has won");
                else {
                    if(player == 'X') player = 'O';
                    else player = 'X';
                }
        
            }
            else System.out.println("Invalid move. Try again!");
        }
        
        //Print the board after the game is over
        printBoard(board);

        sc.close();
    }

    //Function to print the structure and content of the board
    public static void printBoard(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }

    //Function to check if a player has won
    public static boolean haveWon(char[][] board, char player) {

        //Check the rows
        for(int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            } 
        }

        //Check the columns
        for(int col = 0; col < board[0].length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            } 
        }

        //Check the diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
