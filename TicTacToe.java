//sample game

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board;
    private static char currentPlayer;
    private static Scanner scanner; // Class-level Scanner declaration

    public static void main(String[] args) {
        board = new char[3][3];
        currentPlayer = 'X';
        scanner = new Scanner(System.in); // Initialize Scanner here
        initializeBoard();

        while (true) {
            printBoard();
            playerMove();
            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }
            switchPlayer();
        }

        scanner.close(); // Close the Scanner after the game loop ends
    }

    // Initialize the board with empty spaces
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the current state of the board
    private static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Handle player move
    private static void playerMove() {
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid.");
            }
        }
    }

    // Switch player after each move
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check if the board is full
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Check if there is a winner
    private static boolean checkWinner() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    // Check rows for a winner
    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check columns for a winner
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check diagonals for a winner
    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
}