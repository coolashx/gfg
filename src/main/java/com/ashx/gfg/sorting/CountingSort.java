package com.ashx.gfg.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 1, 0, 1};
        countingSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr, int k) {
        int n = arr.length;
        int[] count = new int[k];
        for (int j : arr) {
            count[j]++;
        }
        for (int i = 1; i < k; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}
