package com.ashx.gfg.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        System.out.println(mChainRec(arr));
        System.out.println(mChainDP(arr));
    }

    public static int mChainRec(int[] arr) {
        return mChainRec(arr, 0, arr.length - 1);
    }

    private static int mChainRec(int[] arr, int i, int j) {
        if (i + 1 == j) { // Single Matrix
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res,
                    mChainRec(arr, i, k)
                            + mChainRec(arr, k, j)
                            + arr[i] * arr[j] * arr[k]
            );
        }

        return res;
    }

    public static int mChainDP(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        // dp[i][j] = Store the result for sub-array from i to j
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 0; // Single Matrix
        }
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k]
                                    + dp[k][j]
                                    + arr[i] * arr[j] * arr[k]
                    );
                }
            }
        }

        return dp[0][n - 1];
    }
}
