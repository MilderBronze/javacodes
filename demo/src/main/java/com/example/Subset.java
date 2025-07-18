package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        // List<List<Integer>> newAns = iterativePrgToPrintSubsequencesDuplicates(nums);
        // for (List<Integer> row : newAns) {
        //     System.out.println(row);
        // }
        // int target = 12;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, list, temp, 0);
        for (List<Integer> sublist : list) {
            System.out.println(sublist);
        }
        // int count = 0;
        // for (List<Integer> sublist : list) {
        //     if (sublist.isEmpty()) {
        //         continue;
        //     }
        //     if ((sublist.get(0) + sublist.get(sublist.size() - 1)) <= target) {
        //         count++;
        //     }
        // }
        // System.out.println("count is: " + count);

    }

    // void return type
    public static void helper(int[] nums, List<List<Integer>> list, List<Integer> temp, int i) {
        if (i == nums.length) {
            List<Integer> newList = new ArrayList<>(temp);
            list.add(newList);
            return;
        }
        
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            helper(nums, list, temp, j + 1);
            temp.remove(temp.size() - 1);
            // helper(nums, list, temp, i + 1);
        }
    }

    public static List<List<Integer>> iterativePrgToPrintSubsequences(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : nums) {
            // create as many new lists inside of outer as there were before, thus, creating
            // a clone of outer.
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    public static List<List<Integer>> iterativePrgToPrintSubsequencesDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int s = 0;
        int e = 0;
        for (int i = 0; i < nums.length; i++) {
            // create as many new lists inside of outer as there were before, thus, creating
            // a clone of outer.
            s = 0;
            // if current and previous element is sa`me: s = e + 1;
            if ((i - 1) >= 0 && nums[i] == nums[i - 1]) {
                s = e + 1;
            }
            e = outer.size() - 1;
            int n = outer.size();
            for (int j = s; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(nums[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
