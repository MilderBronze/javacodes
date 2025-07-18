package com.example;

import java.util.Scanner;

public class PrintMazeWithJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        printMazeWithJumps(1, 1, n, m, "");
    }

    public static void printMazeWithJumps(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }
        if (sr < 0 || sc < 0) {
            return;
        }
        if (sr > dr || sc > dc) {
            return;
        }
        // horizontal rows:
        for (int ms = 1; ms <= dc - sc; ms++) {
            printMazeWithJumps(sr, sc + ms, dr, dc, psf + "h" + ms);
        }
        // vertical rows:
        for (int ms = 1; ms <= dr - sr; ms++) {
            printMazeWithJumps(sr + ms, sc, dr, dc, psf + "v" + ms);
        }
        // diagonal rows:
        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            printMazeWithJumps(sr + ms, sc + ms, dr, dc, psf + "d" + ms);
        }
    }
}
