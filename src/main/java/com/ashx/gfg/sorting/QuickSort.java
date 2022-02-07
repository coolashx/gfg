package com.ashx.gfg.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr1 = {8, 4, 7, 9, 3, 10, 5};
        lomutoQuickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {8, 4, 7, 9, 3, 10, 5};
        hoareQuickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    public static void lomutoQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = LomutoPartition.partition(arr, low, high);
            lomutoQuickSort(arr, low, p - 1);
            lomutoQuickSort(arr, p + 1, high);
        }
    }

    public static void hoareQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = HoarePartition.partition(arr, low, high);
            hoareQuickSort(arr, low, p);
            hoareQuickSort(arr, p + 1, high);
        }
    }
}
