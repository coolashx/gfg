package com.ashx.gfg.dp;

public class ZeroToOneKnapsackProblem {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};
        int W = 10;
        System.out.println(knapSackRec(W, wt, val));
        System.out.println(knapSackDP(W, wt, val));
    }

    public static int knapSackRec(int W, int[] wt, int[] val) {
        int n = wt.length;
        return knapSackRec(W, wt, val, n);
    }

    private static int knapSackRec(int W, int[] wt, int[] val, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (wt[n - 1] > W) {
            // If current weight is higher than require weight, ignore it.
            return knapSackRec(W, wt, val, n - 1);
        } else {
            // Get max of cases considering current weight vs not considering it
            return Math.max(
                    knapSackRec(W, wt, val, n - 1), // Not considering current weight
                    val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n - 1) // Considering current weight
            );
        }
    }

    public static int knapSackDP(int W, int[] wt, int[] val) { // Theta (n * W)
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        // dp[i][j] = Max val that we can collect with first i items and knapsack capacity j.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    // If current weight is higher than require weight, ignore it.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Get max of cases considering current weight vs not considering it
                    dp[i][j] = Math.max(
                            dp[i - 1][j], // Not considering current weight
                            val[i - 1] + dp[i - 1][j - wt[i - 1]] // Considering current weight
                    );
                }
            }
        }
        return dp[n][W];
    }
}
