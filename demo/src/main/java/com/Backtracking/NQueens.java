package com.Backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        for (int r = 0; r <= row; r++) {
            if (board[r][col]) {
                return false;
            }
        }
        // checking the diagonals:
        // left diagonal:
        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        // right diagonal:
        while (r >= 0 && c < board.length) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            // got one combination
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
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
}
