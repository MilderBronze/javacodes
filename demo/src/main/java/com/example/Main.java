package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // inc(n);
        // dec(n);
        pdi(n);
    }

    public static void inc(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        inc(n - 1);
    }

    public static void dec(int n) {
        if (n == 0)
            return;
        dec(n - 1);
        System.out.println(n);
    }
    public static void pdi(int n){
        if(n == 0) return;
        System.out.println(n);
        pdi(n - 1);
        System.out.println(n);
    }
}