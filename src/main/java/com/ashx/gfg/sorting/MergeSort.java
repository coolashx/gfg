package com.ashx.gfg.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 5, 30, 15, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (r > l) {
            int m = l + (r - l) / 2;
            if (l < m) {
                mergeSort(arr, l, m);
            }
            if (m + 1 < r) {
                mergeSort(arr, m + 1, r);
            }
            Merge.merge(arr, l, m, r);
        }
    }
}
