package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GetKeypadCombination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> words = getKPC(str);
        System.out.println(words);
    }
    static String[] codes = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // created the global array
                            // 0  1    2      3      4      5      6      7      8       9
    
    public static ArrayList<String> getKPC(String str){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add(""); 
            return bres;
        }
        
        char chh = str.charAt(0);
        int ch = chh - '0'; 
        String ros = str.substring(1);

        ArrayList<String> m = new ArrayList<>();
        String codeforch = codes[ch];
        ArrayList<String> a = getKPC(ros);

        for (int i = 0; i < codeforch.length(); i++) {
            char chcode = codeforch.charAt(i);
            for(String eachEle: a){
                m.add(chcode + eachEle);
            }
        }
        return m;
    }

}
