package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> paths = getMazePaths(1, 1, n, m); // meaning (1, 1) se hame (n, m) jaana hai
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
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

        ArrayList<String> hpaths = getMazePaths(sr, sc + 1, dr, dc); // 1
        ArrayList<String> vpaths = getMazePaths(sr + 1, sc, dr, dc); // 2
        ArrayList<String> paths = new ArrayList<>(); // 3
        for (String path : hpaths) { // 4
            paths.add("h" + path);
        }
        for (String path : vpaths) { // 5
            paths.add("v" + path);
        }
        return paths; // 6
    }
}
