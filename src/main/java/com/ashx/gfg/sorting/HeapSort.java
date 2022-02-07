package com.ashx.gfg.sorting;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 15, 50, 4, 20};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Refer {@link com.ashx.gfg.heap.MinHeap}
     *
     * @param arr Array to sort
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n); // {50, 20, 10, 4, 15}
        for (int size = n - 1; size >= 1; size--) {
            ArrayUtils.swap(arr, 0, size);
            maxHeapify(arr, size, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    private static void maxHeapify(int[] arr, int size, int idx) {
        int largest = idx, left = 2 * idx + 1, right = 2 * idx + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != idx) {
            ArrayUtils.swap(arr, largest, idx);
            maxHeapify(arr, size, largest);
        }
    }
}
