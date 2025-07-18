package com.example;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutations("", "abc");
        ArrayList<String> res = permutationRet("", "abc");
        System.out.println(res);
        System.out.println(countPermut("", "abc"));
    }

    public static void permutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return; 
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);
            permutations(first + ch + second, unprocessed.substring(1));
        } 
    }
    public static ArrayList<String> permutationRet(String p, String up){
        // jab list return krna ho toh list.addall kr skte ho.
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i);
            // iss question me sirf formula banane ka deri tha.
            ArrayList<String> newAns = permutationRet(first + ch + second, up.substring(1));
            ans.addAll(newAns);
        }
        return ans;
    }
    public static int countPermut(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0); 
        int count = 0;
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i);
            count += countPermut(first + ch + second, up.substring(1));
        }
        return count;
    }
}