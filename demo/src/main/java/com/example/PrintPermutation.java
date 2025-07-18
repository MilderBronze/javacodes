package com.example;

import java.util.Scanner;

public class PrintPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printPermutation(str, "");
    }

    public static void printPermutation(String ques, String psf) {
        // if ("".equals(ques)) { or write this:
        if (ques.length() == 0) {
            System.out.println(psf);
            return;
        }
        for (int i = 0; i <= ques.length() - 1; i++) {
            char cho = ques.charAt(i);
            String roq;
            if (i == 0) {
                roq = ques.substring(1);
            } else if (i > 0 && i < ques.length() - 1) {
                roq = ques.substring(0, i) + ques.substring(i + 1);
            } else {
                roq = ques.substring(0, i);
            }
            printPermutation(roq, psf + cho);
        }
    }
}
