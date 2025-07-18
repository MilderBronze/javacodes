package com.example;
import java.util.Scanner;

public class PrintSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printSS(str, ""); // meaning (1, 1) se hame (n, m) jaana hai
    }

    public static void printSS(String ques, String ans) {
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String roq = ques.substring(1); // rest of question
        printSS(roq, ans + ch);
        printSS(roq, ans + "");
    }
}   
 