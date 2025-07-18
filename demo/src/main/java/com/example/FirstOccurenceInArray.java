package com.example;

public class FirstOccurenceInArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 13, 4, 12, 3, 10, 11, 2, 13, 11, 10, 1, 21 };
        System.out.println("the first occurence of the key is " + firstOccurInArr(arr, 11, 0));
        System.out.println("the last occurence of the key is " + lastOccurInArr(arr, -1, 0));
    }

    // public static int lastOccurInArr(int[] arr, int key, int idx) {
    //     if (idx == arr.length) {
    //         return -1;
    //     }
    //     int ans = lastOccurInArr(arr, key, idx + 1); // possible values of ans is all indices and -1 if key not found. so first check if ans == -1 or not else if you check for arr[ans] first then it might be the case that arr[-1] is being checked which is gonna give to us an index out of bounds error.

    //     if (ans == -1) {
    //         if (arr[idx] == key)
    //             return idx;
    //         else
    //             return -1;
    //     } else
    //         return ans;
    // }
    public static int lastOccurInArr(int[] arr, int key, int idx){
        if (idx == arr.length)
            return -1;
        int ans = lastOccurInArr(arr, key, idx + 1);
        if(ans == -1){
            if(arr[idx] == key) return idx;
        }
        // upar else case nai le rhe hain jaise isse pehle wale commented function ke code me liye thhe. because anyways agar arr[ans] and arr[idx], dono hii jagah key nahi mila toh fiir ans will be -1 only jo ki next line (currently line number 32) me return ho hii jaega.
        return ans;
    }

    public static int firstOccurInArr(int[] arr, int key, int idx) {
        if (idx == arr.length)
            return -1;
        if (arr[idx] == key) {
            return idx;
        } else
            return firstOccurInArr(arr, key, idx + 1);
    }

}
