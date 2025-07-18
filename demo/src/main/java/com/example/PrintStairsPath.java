package com.example;

import java.util.Scanner;

public class PrintStairsPath {
    // this question involves usage of levels and options trick.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStairPath(n, "");
    }

    public static void printStairPath(int n, String path) {
        // if (n < 0)
        // return; // agar journey krte krte negative chale gye toh simply return back
        if (n == 0) {
            System.out.println(path);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if ((n - i) >= 0) // meaning do not run the function for negative ones
                printStairPath(n - i, path + i);
        } // do this or do this:
        /**
         * if(n-1>=0)
         *      printStairPath(n-1, path+"1");
         * if(n-2>=0)
         *      printStairPath(n-2, path+"2");
         * if(n-3>=0)
         *      printStairPath(n-3, path+"3");
         */
    }
}
// this whole answer was written after drawing the euler tree.
// so these are levels and options type.
// isse pehle wala type tha faith and expectation type.
// faith expectation style upar se neeche ki taraf solve hoti hai.
// levels and options type solve hota hai upar jaate waqt (euler) and base case me answer hota hai (either printing or returning something).