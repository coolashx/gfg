package com.ashx.gfg.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {30, 40, 10, 80, 5, 12, 70};
        bucketSort(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr, int k) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        max++;
        ArrayList<ArrayList<Integer>> bkt = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bkt.add(new ArrayList<>());
        }
        for (int j : arr) {
            int bi = (k * j) / max;
            bkt.get(bi).add(j);
        }
        for (int i = 0; i < k; i++) {
            Collections.sort(bkt.get(i));
        }
        int idx = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bkt.get(i).size(); j++) {
                arr[idx++] = bkt.get(i).get(j);
            }
        }
    }
}
