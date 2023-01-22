import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        printBoard(board);

        while(true) {
            playerTurn(board, scanner);
            if (isGameOver(board, 'X')) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameOver(board, 'O')) {
                break;
            }
            printBoard(board);
        }

        scanner.close();
    }

    private static boolean isGameOver(char[][] board, char symbol) {

        if (hasContestantWon(board, symbol)) {
            printBoard(board);
            if (symbol == 'X') {
                System.out.println("Player won!");
            } else {
                System.out.println("Computer won!");
            }

            return true;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerMove;

        while (true) {
            computerMove = random.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) break;
        }
        System.out.println("Computer chose: "+ computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    public static boolean isValidMove(char[][] actualBoard, String compInput) {

        switch (compInput) {
            case "1":
                return actualBoard[0][0] == ' ';
            case "2":
                return actualBoard[0][1] == ' ';
            case "3":
                return actualBoard[0][2] == ' ';
            case "4":
                return actualBoard[1][0] == ' ';
            case "5":
                return actualBoard[1][1] == ' ';
            case "6":
                return actualBoard[1][2] == ' ';
            case "7":
                return actualBoard[2][0] == ' ';
            case "8":
                return actualBoard[2][1] == ' ';
            case "9":
                return actualBoard[2][2] == ' ';
            default:
                return false;
        }

    }

    private static void playerTurn(char[][] board, Scanner scanner) {

        System.out.println("What is your next move? (1-9)");
        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)) break;

            System.out.println("That was not a valid move! Try again: ");
        }


        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Bad move :(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}
