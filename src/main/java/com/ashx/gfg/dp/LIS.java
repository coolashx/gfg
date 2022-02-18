package com.ashx.gfg.dp;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 */
public class LIS {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 8, 10, 5, 1};
        System.out.println(lis_dp(arr));
        System.out.println(lis_binarysearch(arr));
    }

    public static int lis_dp(int[] arr) { // O(n^2)
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        return Arrays.stream(lis).max().getAsInt();
    }

    public static int lis_binarysearch(int[] arr) { // O(n * log n)
        int n = arr.length, len = 1;
        int[] tail = new int[n];
        tail[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len++] = arr[i];
            } else {
                int c = ceilIdx(tail, len, arr[i]);
                tail[c] = arr[i];
            }
        }

        return len;
    }

    private static int ceilIdx(int[] tail, int len, int x) {
        int l = 0, r = len - 1;
        while (r > l) {
            int m = l + (r - l) / 2;
            if (tail[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
