package com.ashx.gfg.sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {319, 212, 6, 8, 100, 50};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int n = arr.length;
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        for (int exp = 1; mx / exp > 0; exp = exp * 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int base = 10;
        int[] count = new int[base];
        for (int j : arr) {
            count[(j / exp) % base]++;
        }
        for (int i = 1; i < base; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % base] - 1] = arr[i];
            count[(arr[i] / exp) % base]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}
