package com.example;

import java.util.Arrays;

public class TrialApp2 {

    public static void main(String[] args) {
        int arr[] = {2, 10, 7, 18, 5, 33, 0};
        int k = 1 , m = 3;
        System.out.println(maxSumOfMSubarrays(arr, k, m));
    }

    public static int maxSumOfMSubarrays(int[] nums, int k, int m) {
        int n = nums.length;
        int[] subarraySums = new int[n - k + 1];

        // Precompute all subarray sums of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) windowSum += nums[i];
        subarraySums[0] = windowSum;

        for (int i = 1; i <= n - k; i++) {
            windowSum = windowSum - nums[i - 1] + nums[i + k - 1];
            subarraySums[i] = windowSum;
        }

        // Memoization table
        int[][] dp = new int[n][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return rec(subarraySums, 0, m, k, dp);
    }

    // Recursive function with memoization
    public static int rec(int[] sub, int i, int m, int k, int[][] dp) {
        if (m == 0) return 0;
        if (i > sub.length - k || i >= sub.length) return Integer.MIN_VALUE;

        if (dp[i][m] != -1) return dp[i][m];

        // Take current subarray
        int take = sub[i] + rec(sub, i + k, m - 1, k, dp);
        // Don't take current, move forward
        int skip = rec(sub, i + 1, m, k, dp);

        return dp[i][m] = Math.max(take, skip);
    }
}
