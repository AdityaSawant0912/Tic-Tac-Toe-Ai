

import java.util.Scanner;

public class gameBoard {
    char[][] board = new char[3][3];
    char x = 'X';
    char o = 'O';
    int length = 3;

    gameBoard() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public Boolean isFull() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public char checkBoard() {
            for (int i = 0; i < length; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                    return board[i][0];
                }
            }

            // Check each column
            for (int j = 0; j < length; j++) {
                if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                    return board[0][j];
                }
            }

            // Check the diagonals
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
                return board[0][0];
            }
            if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ') {
                return board[2][0];
            }

            // Otherwise nobody has not won yet
            if(isFull())
                return 'T';
            return ' ';
    }

    public void playBoard(int movePos, char moveChar) {
        int i = 0, j = 0;
        for (int a = 0; a < movePos - 1; a++) {
            if (i < length - 1)
                i++;
            else {
                j++;
                i = 0;
            }
        }
        board[i][j] = moveChar;
    }

    public void displayBoard() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    char ai, human = 'X';

    public int[] bestMove(char aii) {
        ai = aii;
        if (ai == 'X')
            human = 'O';
        int a = -1, b = -1;
        int bestScore = -100000000;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = ai;
                    int score = minimax(0, false, -100, 100);
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        a = i;
                        b = j;
                    }
                }
            }
        }
        int[] aimove = { a, b };
        return aimove;

    }

    public int minimax(int depth, Boolean isMaximizing, int alpha, int beta) {
        char result = checkBoard();
        if (result != ' ') {
            if (result == ai)
                return 10;
            else if (result == human)
                return -10;
            else if (result == 'T')
                return 0;
        }
        if (isMaximizing) {
            int bestScore = -100;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = ai;
                        int score = minimax(depth + 1, false, alpha, beta);
                        board[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                        alpha = Math.max(alpha, bestScore);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 100;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = human;
                        int score = minimax(depth + 1, true, alpha, beta);
                        board[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                        beta = Math.min(beta, bestScore);
                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return bestScore;
        }
    }

    public void playBoard(int i, int j, char move) {
        board[i][j] = move;
    }

    public static void main(String[] args) {
        gameBoard newBoard = new gameBoard();
        Scanner sc = new Scanner(System.in);
        char human = 'X', ai = 'O';
        while (newBoard.checkBoard() == ' ') {
            newBoard.displayBoard();
            int i = sc.nextInt();
            int j = sc.nextInt();
            newBoard.playBoard(i, j, human);
            int[] aimove = newBoard.bestMove(ai);
		    newBoard.playBoard(aimove[0], aimove[1], ai);
            System.out.println(newBoard.checkBoard());
        }
        sc.close();
    }
}
