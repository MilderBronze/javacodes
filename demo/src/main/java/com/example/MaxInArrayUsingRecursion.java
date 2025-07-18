package com.example;

public class MaxInArrayUsingRecursion {
    public static void main(String[] args) {
        int[] arr = new int[]{1134, 123, 1011, 21110, 10001};
        System.out.println(MaxInArrayUsRec(arr, 0));
    }
    public static int MaxInArrayUsRec(int[] arr, int idx){
        if(idx == arr.length - 1){
            return arr[idx];
        }
        int maxInSmallerArray = MaxInArrayUsRec(arr, idx + 1);
        return ((maxInSmallerArray < arr[idx]) ? arr[idx] : maxInSmallerArray);
    }
}
