package com.ashx.gfg.dp;

import java.util.Arrays;

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        int[] arr = {20, 5, 4, 6};
        System.out.println(solRec1(arr));
        System.out.println(solRec2(arr));
        System.out.println(solDP(arr));
    }

    public static int solRec1(int[] arr) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        return solRec1(arr, 0, n - 1, sum);
    }

    private static int solRec1(int[] arr, int i, int j, int sum) {
        if (j == i + 1) {
            return Math.max(arr[i], arr[j]);
        }
        return Math.max(sum - solRec1(arr, i + 1, j, sum - arr[i]),
                sum - solRec1(arr, i, j - 1, sum - arr[j]));
    }

    public static int solRec2(int[] arr) {
        int n = arr.length;
        return solRec2(arr, 0, n - 1);
    }

    private static int solRec2(int[] arr, int i, int j) {
        if (i + 1 == j) {
            // If only 2 coins are remaining, return max coin.
            return Math.max(arr[i], arr[j]);
        }
        return Math.max(
                // If we pick i coin, opponent will pick either i+1 or j coin
                arr[i] + Math.min(
                        solRec2(arr, i + 2, j), // Opponent pick i+1 coin
                        solRec2(arr, i + 1, j - 1) // Opponent pick j coin
                ),
                // If we pick j coin, opponent will pick either i or j-1 coin
                arr[j] + Math.min(
                        solRec2(arr, i + 1, j - 1), // Opponent pick i coin
                        solRec2(arr, i, j - 2) // Opponent pick j-1 coin
                )
        );
    }

    public static int solDP(int[] arr) { // Theta (n^2)
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            // If only 2 coins are remaining, return max coin.
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        }
        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(
                        // If we pick i coin, opponent will pick either i+1 or j coin
                        arr[i] + Math.min(
                                dp[i + 2][j], // Opponent pick i+1 coin
                                dp[i + 1][j - 1] // Opponent pick j coin
                        ),
                        // If we pick j coin, opponent will pick either i or j-1 coin
                        arr[j] + Math.min(
                                dp[i + 1][j - 1], // Opponent pick i coin
                                dp[i][j - 2] // Opponent pick j-1 coin
                        )
                );
            }
        }


        return dp[0][n - 1];
    }
}
