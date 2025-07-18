package com.example;

import java.util.Scanner;

// in recursion, there are 2 kinds of problems that you are gonna see.
// one type is the faith expectation method
// the second one is logic options. All printing wale questions in this directory belongs to the latter type.

// to solve this you need to know getMazePaths and printSubsequence problems.
public class PrintMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printMaze(1, 1, n, m, "");
    }

    public static void printMaze(int sr, int sc, int dr, int dc, String psf) // psf is path so far
    {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        // horizontal rows:
        printMaze(sr, sc + 1, dr, dc, psf + "h");
        // vertical rows:
        printMaze(sr + 1, sc, dr, dc, psf + "v");
        // diagonal rows:
        printMaze(sr + 1, sc + 1, dr, dc, psf + "d");
    }
    public static int printMazeCount(int sr, int sc, int dr, int dc, String psf, int count) // psf is path so far
    {
        if (sr == dr && sc == dc) {
            return count;
        }
        if (sr > dr || sc > dc) {
            return count;
        }
        count += printMazeCount(sr, sc + 1, dr, dc, psf + "h", count) + printMazeCount(sr + 1, sc, dr, dc, psf + "v", count);
        return count;
    }
}
