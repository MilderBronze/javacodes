package com.example;

import java.util.ArrayList;

public class PhonePad {
    // subset - processed and unprocessed approach + take not take method
    public static void main(String[] args) {
        pad("", "12");
        System.out.println(padCount("", "12"));
        System.out.println(padList("", "12"));
    }

    public static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            // now just add it in the recursion call
            pad(p + ch, up.substring(1));
        }

    }

    public static ArrayList<String> padList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            // now just add it in the recursion call
            ArrayList<String> newAns = padList(p + ch, up.substring(1));
            ans.addAll(newAns);
        }
        return ans;

    }

    public static int padCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = up.charAt(0) - '0';

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count = count + padCount(p + ch, up.substring(1));
        }
        return count;
    }
}
 