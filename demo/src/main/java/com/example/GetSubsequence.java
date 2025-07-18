package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        // ArrayList<String> res = gss(str);
        // System.out.println(res);

        // alternate tareeka ka code:
        // alternateTareeka("", str);

        System.out.println(subsequenceReturnedInArrayList("", "abc"));
    }

    // faith is [--, b-, -c, bc]
    // expectation is [---, -b-, --c, -bc, a--, ab-, a-c, abc] <- this is how a
    // subsequence looks like. there are 2 ^ n arrangements of a subsequence, where
    // n is the length of the string. here, abc so 3. 2 ^ 3 is 8.
    // substring means: for abc: a, ab, abc, b, bc, c // n*(n+1)/2
    public static ArrayList<String> gss(String str) {
        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        char ch = str.charAt(0);
        // ros mtlb rest of string.
        String ros = str.substring(1); // 1 se lekar end tak ka alag kr diya. if you do not mention second parameter
                                       // inside of substring method, then wo end tk consider krta hai. // a
        ArrayList<String> recursionResult = gss(ros); // this will bring the result for rest of string. // [--, b-, -c,
                                                      // bc]
        ArrayList<String> myResult = new ArrayList<>();
        myResult.addAll(recursionResult);
        for (String recursionString : recursionResult) {
            myResult.add(ch + recursionString);
        }
        return myResult;

    }

    public static void alternateTareeka(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        alternateTareeka(p + ch, up.substring(1)); // strings are immutable, .substring is not changing "up". its
                                                   // creating
                                                   // a new copy of "up".
        alternateTareeka(p, up.substring(1));
    }

    public static ArrayList<String> subsequenceReturnedInArrayList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> base = new ArrayList<>();
            base.add(p);
            return base;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subsequenceReturnedInArrayList(p + ch, up.substring(1));
        ArrayList<String> right = subsequenceReturnedInArrayList(p, up.substring(1));
        System.out.println("left"+ left);
        System.out.println("right"+right);
        left.addAll(right);
        return left;
    }
}
