package com.example;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
        fn(0, 6, new ArrayList<>(), 6);
    }

    public static void fn(int p, int up, List<Integer> l, int target) {
        if (up == 0) {
            System.out.println(l);
            return;
        }
        List<Integer> ogList = new ArrayList<>();
        ogList.addAll(l);
        for (int i = 1; i <= 6; i++) {
            if (p + i <= target) {
                ogList.add(i);
                fn(p + i, up - i, ogList, target);
                ogList.remove(ogList.size() - 1);
            }
        }
    }

}