package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairsPath {
    // this will require the formation of euler while solving this problem because
    // there aint a single call. there are multiple calls.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> paths = getStairPath(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPath(int n) {
        ArrayList<String> ans = new ArrayList<>(); // this is the main part of the code, changing its position is
                                                   // leading to a drastic change in the output. If we keep this line
                                                   // inside of this function, then we get right output, if we keep this
                                                   // as a global function, it gives wrong output.
        // base condition: 
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if ((n - 1) >= 0) {
            ArrayList<String> list1 = getStairPath(n - 1); // having faith that this will give me {11, 2} in case
                                                           // input is 3.
            for (String item : list1) {
                ans.add("1" + item);
            }
            // return ans; // this is mistake, you dont want to return anything from
            // here as it would cause below codes to not run.
        }
        if ((n - 2) >= 0) {
            ArrayList<String> list2 = getStairPath(n - 2); // having faith that this will give me {1} in case input is
                                                           // 3.
            for (String item : list2) {
                ans.add("2" + item);
            }
            // return ans;
        }
        if ((n - 3) >= 0) {
            ArrayList<String> list3 = getStairPath(n - 3); // having faith that this will give me {""} in case input is
                                                           // 3.
            for (String item : list3)
                ans.add("3" + item);
        }
        return ans;
    }
}
