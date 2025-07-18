package com.example;

import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of discs: ");
        int n = sc.nextInt();
        toh(n, "A", "B", "C");
    }

    public static void toh(int n, String A, String B, String C){
        if(n == 0) return; // meaning, if there are no discs, do nothing, simply return.
        toh(n - 1, A, C, B);
        System.out.println("move disc from " + A + " to " + B);
        toh(n - 1, C, B, A);
    }
}
