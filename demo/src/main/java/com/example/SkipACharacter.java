package com.example;

public class SkipACharacter {
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        // sas("", str); // meaning skip a string
        System.out.println(anotherMethodToSolveThis("bccaaabdac"));
        System.out.println(skipApple("iappleloveappleappiapple"));
        System.out.println(onlySkipAppWhenItsNotEqualToApple("appappleapple"));
    }

    // this method is processed - unprocessed method
    public static void sas(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        // you can either do this
        if (up.charAt(0) != 'a') {
            sas(p + up.charAt(0), up.substring(1));
        }
        // or do this
        sas(p, up.substring(1));
        // if (up.charAt(0) != 'a') {
        // p = p + up.charAt(0);
        // }
        // sas(p, up.substring(1));
    }

    // this method is faith - expectation method
    public static String anotherMethodToSolveThis(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.charAt(0) != 'a') {
            return str.charAt(0) + anotherMethodToSolveThis(str.substring(1));
        } else
            return "" + anotherMethodToSolveThis(str.substring(1));

    }

    // skipping a particular string:
    public static String skipApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("apple")) {
            return skipApple(str.substring(5));
        }
        return str.charAt(0) + skipApple(str.substring(1));
    }

    public static String onlySkipAppWhenItsNotEqualToApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("app") && !str.startsWith("apple")) {
            return onlySkipAppWhenItsNotEqualToApple(str.substring(3));
        }
        return str.charAt(0) + onlySkipAppWhenItsNotEqualToApple(str.substring(1));
    }
}
