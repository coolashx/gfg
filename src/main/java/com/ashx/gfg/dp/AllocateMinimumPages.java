package com.ashx.gfg.dp;

import java.util.Arrays;

/**
 * Also check {@link com.ashx.gfg.search.AllocateMinimumPages}
 */
public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30};
        int k = 2;
        System.out.println(minPagesRec(arr, k));
        System.out.println(minPagesDP(arr, k));
    }

    public static int minPagesRec(int[] arr, int k) {
        return minPagesRec(arr, arr.length, k);
    }

    private static int minPagesRec(int[] arr, int n, int k) {
        if (k == 1) {
            return sum(arr, 0, n - 1); // When there is only 1 person
        }
        if (n == 1) {
            return arr[0]; // When there is only 1 book
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res,
                    Math.max(minPagesRec(arr, i, k - 1), sum(arr, i, n - 1))
            );
        }

        return res;
    }

    private static int sum(int[] arr, int b, int e) {
        return Arrays.stream(arr, b, e + 1).sum();
    }

    public static int minPagesDP(int[] arr, int k) { // O(k * n^3)
        int n = arr.length;
        int[][] dp = new int[k + 1][n + 1];
        // dp[i][j] = Min pages for i people and j books
        for (int i = 1; i <= n; i++) {
            dp[1][i] = sum(arr, 0, i - 1); // When there is only 1 person
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = arr[0]; // When there is only 1 book
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                int res = Integer.MAX_VALUE;
                for (int p = 1; p < j; p++) {
                    res = Math.min(res,
                            Math.max(dp[i - 1][p], sum(arr, p, j - 1))
                    );
                }
                dp[i][j] = res;
            }
        }
        return dp[k][n];
    }
}
