package com.ashx.gfg.hashing;

import java.util.HashMap;
import java.util.Map;

public class MoreThan_n_by_k_Occurrences {
    public static void main(String[] args) {
        int[] arr = {30, 10, 20, 20, 20, 10, 40, 30, 30};
        occurrences(arr, 4);
    }

    public static void occurrences(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            } else if (map.size() < (k - 1)) {
                map.put(i, 1);
            } else {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == 1) {
                        map.remove(entry.getKey());
                    } else {
                        map.put(entry.getKey(), entry.getValue() - 1);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= n / k) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
