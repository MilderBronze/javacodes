package com.example;

import java.util.Arrays;

public class TrialApp {
    public static int[] dp;

    public static void main(String[] args) {
        int[] cost = { 10, 15, 20 };
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        System.out.println(fn(-1, 0, cost));
    }

    public static int fn(int i, int cost, int[] costArr) {

        if (i == costArr.length)
            return cost;

        if (i != -1 && dp[i] != -1)
            return dp[i];
        int newCost = (i == -1) ? (0) : (cost + costArr[i]);

        int cost1 = fn(i + 1, newCost, costArr);
        int cost2 = Integer.MAX_VALUE;
        if (i + 2 <= costArr.length) {
            cost2 = fn(i + 2, newCost, costArr);
        }
        if (i < 0) {
            return Math.min(cost1, cost2);
        } else {
            dp[i] = Math.min(cost1, cost2);
            return dp[i];
        }
        // return Math.min(cost1, cost2);

    }
}
