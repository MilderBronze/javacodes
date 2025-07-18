package com.example;

import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncoding(str, "");
    }

    public static void printEncoding(String ques, String asf) {
        switch (ques.length()) {
            case 0 -> {
                System.out.println(asf);
                return;
            }
            case 1 ->  {
                char ch = ques.charAt(0);
                if (ch == '0') {
                    return;
                } else {
                    int chv = ch - '0';
                    char code = (char) ('a' + chv - 1);
                    asf = asf + code;
                    System.out.println(asf);
                }
            }
            default ->  {
                char ch = ques.charAt(0);
                String roq = ques.substring(1);
                if (ch == '0') {
                    return;
                } else {
                    int chv = ch - '0';
                    char code = (char) ('a' + chv - 1);
                    asf = asf + code;
                    System.out.println(asf);
                }
            }
        }
    }
}
