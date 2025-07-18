package com.example;

import java.util.Scanner;

public class SkipAnEntireString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sas("", str); // meaning skip a string
    }
    public static void sas(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (up.startsWith("apple")) {
            sas(p, up.substring(5));
        } else {
            sas(p + ch, up.substring(1));

        }
    }
}
