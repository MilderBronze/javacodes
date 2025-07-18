package com.example;

import java.util.Scanner;

public class XToThePowerN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter x: ");
        int x = sc.nextInt();
        System.out.println("enter n: ");
        int n = sc.nextInt();
        System.out.println(xToN(x, n));
        // System.out.println(xToN_Logarithmic(x, n));
    }
    public static int xToN(int x, int n){
        if(n == 1){
            return x;
        }
        return x * xToN(x, n - 1);
    }
    public static int xToN_Logarithmic(int x, int n){
        if(n == 0) return 1;
        int xn = xToN_Logarithmic(x, n/2);
        int ans = xn * xn;
        if (n % 2 == 1){
            return (ans * x);
        } 
        return ans;
    
    }
}
  