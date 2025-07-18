package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LIS {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6, 4, 7 };
        System.out.println(newApproach1(nums));
    }

    public static int newApproach1(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        int lastIndex = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            hash[i] = i; // storing the index as default
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && 1 + dp[prev] == dp[i]) {
                    count++;
                }
                if (arr[i] > arr[prev] && 1 + dp[prev] >= dp[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                    hash[i] = prev;
                }
            }
            if (dp[i] > max) {
                lastIndex = i;
                max = dp[i];
            }
        }
        // ab hash array is ready and the variable lastIndex is pointing to the element
        // which has the highest LIS. like if the array is 5, 4, 11, 1, 16, 8 then
        // lastIndex is gonna be 4.
        // System.out.println(count);
        List<Integer> list = new ArrayList<>();
        System.out.println("lastindex " + lastIndex);
        while (lastIndex != hash[lastIndex]) {
            list.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        } // this will leave the last element hence at last we add the last element as
          // well to the list.
        list.add(arr[lastIndex]); // add the last (or only) element
        Collections.reverse(list);
        System.out.println(list);
        System.out.println(Arrays.toString(hash));
        return max;
    }
}
