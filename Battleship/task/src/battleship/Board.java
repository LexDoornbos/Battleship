package battleship;

import java.util.Arrays;

public class Board {

    final int BOARDSIZE = 10;
    char[][] board = new char[BOARDSIZE][BOARDSIZE];

    public Board() {

        for (char[] cell : board) {
            Arrays.fill(cell, '~');
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < BOARDSIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printFogBoard() {
        System.out.print("  ");
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < BOARDSIZE; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < BOARDSIZE; j++) {
                if(board[i][j] == 'O') { System.out.print("~ ");}
                else {System.out.print(board[i][j] + " ");}
            }
            System.out.println();
        }
    }

    public void markShip(int x1, int y1, int x2, int y2) {
        // for horizontal marking
        if (x1 == x2) {
            // in case user entered coordinates left to right
            if (y1 < y2) {
                for (int i = y1; i <= y2; i++) {
                    board[x1][i] = 'O';
                }
                // in case user entered coordinates left to right
            } else {
                for (int i = y2; i <= y1; i++) {
                    board[x1][i] = 'O';
                }
            }
        }
        // for vertical marking
        if (y1 == y2) {
            // in case user entered coordinates top to bottom
            if (x1 < x2) {
                for (int i = x1; i <= x2; i++) {
                    board[i][y1] = 'O';
                }
                // in case user entered coordinates bottom to top
            } else {
                for (int i = x2; i <= x1; i++) {
                    board[i][y1] = 'O';
                }
            }
        }
    }

    public void markShot(int x, int y) {
        if(board[x][y] == 'O') {
            board[x][y] = 'X';
            printFogBoard();
            System.out.println("\nYou hit a ship!\n");
            printBoard();
        }
        if(board[x][y] == '~') {
            board[x][y] = 'M';
            printFogBoard();
            System.out.println("\nYou missed!\n");
            printBoard();
        }
    }

    public boolean isTooClose(int x1, int y1, int x2, int y2) {

        for (int i = x1 - 1; i <= x2 + 1; i++) {
            for (int j = y1 - 1; j <= y2; j++) {
                if (i >= 0 && i < BOARDSIZE && j >= 0 && j < BOARDSIZE) {
                    if (board[i][j] == 'O') {
                        System.out.print("Error! You placed it too close to another one. Try again: ");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
