package com.ashx.gfg.sorting;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 40, 30};
        cycleSortDistinct(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cycleSortDistinct(int[] arr) {
        int n = arr.length;
        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < n; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;
            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < n; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }
        }
    }
}
