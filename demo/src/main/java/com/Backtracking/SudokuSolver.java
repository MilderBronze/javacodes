package com.Backtracking;

public class SudokuSolver {

    public static Boolean isSafe(int[][] board, int row, int col, int val) {
        // sbse pehle row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            // sbse pehle col check
            if (board[i][col] == val) {
                return false;
            }
        }
        // 3x3 grid check
        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int r = rowStart; r < rowStart + 3; r++) {
            for (int c = colStart; c < colStart + 3; c++) {
                if (board[r][c] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // check if cell is empty
                if (board[row][col] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (isSafe(board, row, col, val)) {
                            board[row][col] = val;
                            // recursion
                            Boolean aageSolutionPossible = solve(board);
                            if (aageSolutionPossible) {
                                display(board);
                                System.out.println();
                                return true;
                            }
                            // backtrack and remove val from the place where we added
                            // to see more combinations.
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void display(int[][] board) {
        for (int[] outer : board) {
            for (int inner : outer) {
                System.out.print(inner + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // Write your code here.
        int[][] sudoku = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        solve(sudoku);
    }
}