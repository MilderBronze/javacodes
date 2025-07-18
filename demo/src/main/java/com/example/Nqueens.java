package com.example;

import java.util.Scanner;

public class Nqueens {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] chess = new int[n][n];
        printNqueens(chess, "", 0);
    }

    public static void printNqueens(int[][] chess, String qsf, int row) {
        // goal is to have one queen at all rows.
        // so we know for sure that we are gonna have row + 1.
        // and harek row me n options honge for column. i mean since there are n columns
        // per row, therefore, we have n options to place the queen at.
        if (row == chess.length) {
            System.out.println(qsf);
            return;
        }
        // Thus, we'll require a for loop.
        for (int col = 0; col < chess.length; col++) {
            if (queenEligible(chess, row, col)) {
                chess[row][col] = 1;
                printNqueens(chess, qsf + row + col + " - ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean queenEligible(int[][]chess, int row, int col){
        // checking all vertical positions:
        for(int i = row - 1; i >= 0; i--){
            if(chess[i][col] == 1) return false;
        }

        // no need of checking the horizontal positions because uss certain row me aur possible elements hain hii nahi. because that row is being written to for the first time.

        // checking all diagonal positions (leftwards)
        for(int i = row - 1, j = col - 1; i > 0 && col > 0; i--, j--){
            if(chess[i][j] == 1) return false;
        }
        // checking all diagonal positions (rightwards)
        for(int i = row - 1, j = col + 1; i < chess.length && col < chess.length; i++, j++){
            if(chess[i][j] == 1) return false;
        }
        return true;
    }
}
