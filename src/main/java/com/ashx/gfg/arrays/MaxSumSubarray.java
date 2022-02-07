package com.ashx.gfg.arrays;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -1, 2};
        System.out.println(maxSumSubarray(arr));
        int[] arr1 = {-3, 8, -2, 4, -5, 6};
        System.out.println(maxSumSubarray(arr1)); // O(n)
    }

    public static int maxSumSubarray(int[] arr) {
        int res = arr[0];
        int n = arr.length;
        int maxEnding = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }

        return res;
    }
}
