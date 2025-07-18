package com.example;

public class KunalMaze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
    }

    static int count(int r, int c) { // instead of having p and up, we have r and c.
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }
}
