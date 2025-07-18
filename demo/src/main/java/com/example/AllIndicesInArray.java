package com.example;

import java.util.Arrays;

public class AllIndicesInArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 13, 4, 12, 3, 10, 11, 2, 13, 11, 10, 1, 21 };
        int[] ans = allIndices(arr, 13, 0, 0); // fsf means found so far.
        System.out.println(Arrays.toString(ans));
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        int[] ans;
        if (idx == arr.length) {
            ans = new int[fsf];
            return ans;
        }
        if (arr[idx] == x) {
            fsf++;
        }
        ans = allIndices(arr, x, idx + 1, fsf); // initializing the ans array
        if (arr[idx] == x) {
            if (fsf > 0) { // null check, if fsf is 0 by any chance, this might throw an index out of
                           // bounds exception
                ans[fsf - 1] = idx;
            }
        }
        return ans;
    }
}
