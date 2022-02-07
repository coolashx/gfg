package com.ashx.gfg.sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {10, 20, 40, 20, 30};
        merge(arr, 0, 2, 4);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {5, 10, 30, 15, 7};
        merge(arr1, 3, 3, 4);
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1, n2 = high - mid;
        int[] left = new int[n1], right = new int[n2];
        System.arraycopy(arr, low, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
