package com.ashx.gfg.dp;

/**
 * Also check {@link com.ashx.gfg.recursion.RopeCutting}
 */
public class RopeCutting {
    public static void main(String[] args) {
        System.out.println(maxPieces(23, 11, 9, 12));
        System.out.println(maxPieces(9, 2, 2, 2));
        System.out.println(maxPieces(5, 1, 1, 1));
    }

    public static int maxPieces(int n, int a, int b, int c) { // Theta (n)
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }
            if (dp[i] != -1) {
                dp[i]++;
            }
        }

        return dp[n];
    }
}
