package com.ashx.gfg.sorting;

import org.apache.commons.lang3.ArrayUtils;

public class LomutoPartition {
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        int idx = partition(arr, 0, arr.length - 1);
        System.out.println(idx);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                ArrayUtils.swap(arr, i, j);
            }
        }
        i++;
        ArrayUtils.swap(arr, i, high);
        return i;
    }
}
