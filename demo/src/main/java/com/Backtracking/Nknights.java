package com.Backtracking;

public class Nknights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        knights(board, 0, 0, 4);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (row - 2 >= 0 && col + 1 < board.length && board[row - 2][col + 1]) {
            // then only check
            return false;
        }
        if (row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1]) {
            // then only check
            return false;
        }
        if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2]) {
            return false;
        }
        // if (row - 1 >= 0 && col + 2 < board.length && board[row - 1][col + 2]) {
        //     return false;
        // } do this or:
        return !(row - 1 >= 0 && col + 2 < board.length && board[row - 1][col + 2]);
    }

    static void display(boolean[][] board) {
        for (boolean[] outer : board) {
            for (boolean inner : outer) {
                if (inner) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void knights(boolean[][] board, int row, int col, int target) {
        if (target == 0) {
            // all knights placed
            // found 1 valid combination
            // check for others.
            display(board);
            System.out.println();
            return;
        }
        // else we need to place knights.
        // check if the move is legal
        // agar col ka end reach ho gya hai toh ham fn me row badhaenge wrna sirf col
        // badhega.
        if (row == board.length) {
            // row overflow
            return;
        }
        if (col == board.length && row < board.length) { // try reducing this row < board.length
            // come to next row
            knights(board, row + 1, 0, target);
        } else {
            // check if legal
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                knights(board, row, col + 1, target - 1);
                board[row][col] = false;
                knights(board, row, col + 1, target);
            } else {
                // if illegal
                knights(board, row, col + 1, target);
            }
        }

    }
}
