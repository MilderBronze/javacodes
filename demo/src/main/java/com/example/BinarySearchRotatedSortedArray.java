package com.example;
/**
 * 😄 Yep — that “ooooh” means the lightbulb just went on 💡!

To wrap it up crystal-clear:

👉 Always check nums[m] == target first, because that index might hold your answer.

👉 Then when deciding which half to search, you can confidently exclude m (use m - 1 or m + 1), because you've already handled m.

This is the key to avoiding bugs and infinite loops in rotated binary search. 🔐
 */
public class BinarySearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 3, 1 };
        int target = 1;
        System.out.println("the index is = " + search(nums, 0, nums.length - 1, target));
    }

    static int search(int[] nums, int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if (nums[m] == target)
            return m;
        if (nums[m] >= nums[s]) {
            // first check if target is present in the first line.
            // mtlb this part is sorted. now check if target exists in this part or not.
            // you know... reducing the search space..
            if (target < nums[m] && target >= nums[s]) {
                return search(nums, s, m - 1, target);
            }
            return search(nums, m + 1, e, target);

        } else {
            // checking for the second sorted line.. i.e. mid to end.
            if (target > nums[m] && target <= nums[e]) {
                return search(nums, m + 1, e, target);
            }
            return search(nums, s, m - 1, target);
        }
    }
}
