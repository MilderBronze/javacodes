package com.example;

import java.util.Arrays;

public class MergeSort {
    static int count = 0;

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] first = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(first, second);
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int a = 0, b = 0;
        while (a < first.length && b < second.length) {
            if (first[a] > second[b]) {
                count += first.length - a;
                b++;
            } else {
                a++;
            }
        }
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k++] = first[i++];
            } else {
                mix[k++] = second[j++];
            }
        }
        while (i < first.length) {
            mix[k++] = first[i++];
        }
        while (j < second.length) {
            mix[k++] = second[j++];
        }
        return mix;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 0, 9, 2 };
        System.out.println(Arrays.toString(mergeSort(arr)));
        System.out.println(count);
    }
}