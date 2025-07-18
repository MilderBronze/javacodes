package com.example;

import java.util.ArrayList;
import java.util.Scanner;

// this is a very interesting question because this is a combination of maze path and stairs path problem
public class GetMazePathWithJump {
    // give a dry run to this one. create euler

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> paths = getMazePathsWithJmp(1, 1, n, m); // meaning (1, 1) se hame (n, m) jaana hai
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePathsWithJmp(int sr, int sc, int dr, int dc) {
        if (sc > dc) {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        if (sr > dr) {
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        if (sr == dr && sc == dc) { // agar last position me ho toh kahi mat jao. whi raho. So, for that we return
                                    // an arraylist with 1 element and that is an empty string.
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> paths = new ArrayList<>();

        // horizontal moves
        for (int moveSize = 1; moveSize <= dc - sc; moveSize++) {
            ArrayList<String> hPaths = getMazePathsWithJmp(sr, sc + moveSize, dr, dc);
            for (String path : hPaths) {
                paths.add("h" + moveSize + path);
            }
        }
        // vertical moves
        for (int moveSize = 1; moveSize <= dr - sr; moveSize++) {
            ArrayList<String> vPaths = getMazePathsWithJmp(sr + moveSize, sc, dr, dc);
            for (String path : vPaths) {
                paths.add("v" + moveSize + path);
            }
        }
        // diagonal moves
        for (int moveSize = 1; moveSize <= dc - sc && moveSize <= dr - sr; moveSize++) {
            ArrayList<String> dPaths = getMazePathsWithJmp(sr + moveSize, sc + moveSize, dr, dc);
            for (String path : dPaths) {
                paths.add("d" + moveSize + path);
            }
        }
        return paths;
    }
}
