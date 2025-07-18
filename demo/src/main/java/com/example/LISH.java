package com.example;

import java.util.ArrayList;
import java.util.List;

public class LISH {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(9);
        arr.add(11);
        int key = 8;
        System.out.println(bs(0, arr.size() - 1, key, arr));

    }

    public static int bs(int start, int end, int key, List<Integer> arr) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == key)
                return mid;
            if (mid + 1 < arr.size() && arr.get(mid) < key && arr.get(mid + 1) > key)
                return mid;
            if (mid - 1 >= 0 && arr.get(mid - 1) < key && arr.get(mid) > key)
                return mid - 1;
            if (arr.get(mid) < key)
                start = mid + 1;
            if (arr.get(mid) > key)
                end = mid - 1;
        }
        return start;
    }
}
