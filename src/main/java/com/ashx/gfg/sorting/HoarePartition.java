package com.ashx.gfg.sorting;

import org.apache.commons.lang3.ArrayUtils;

public class HoarePartition {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        int idx = partition(arr, 0, arr.length - 1);
        System.out.println(idx);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            ArrayUtils.swap(arr, i, j);
        }
    }
}
