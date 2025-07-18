package com.example;

import java.util.Scanner;

public class ReverseANumberUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(reversedNum(num));
    }

    public static int reversedNum(int num) {
        // base condition:
        if (num == 0) {
            return 0;
        }

        int len = String.valueOf(num).length();
        // another way of finding the length of a number:
        // int digits = (int) (Math.log10(num)) + 1;
        int firstDigit = num / (int) Math.pow(10, len - 1);
        int remainingNumber = num % ((int) Math.pow(10, len - 1));
        int newResultSoFar = reversedNum(remainingNumber) * 10 + firstDigit;
        return newResultSoFar;
    }
}
