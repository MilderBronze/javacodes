package com.example;
public class PrintArrayUsingRecursion {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 50};
        pf(arr,0); 
        pfInReverse(arr, arr.length - 1);
    }
    public static void pf(int[] arr, int idx){
        if(idx == arr.length) return;
        System.out.println(arr[idx]);
        pf(arr, ++idx);
    }
    public static void pfInReverse(int[] arr, int idx){
        if(idx < 0) return;
        System.out.println(arr[idx]);
        pfInReverse(arr, --idx);
    }
}
