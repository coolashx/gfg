package com.ashx.gfg.dp;

import java.util.Arrays;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 2, 1};
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) { // Theta (n^2)
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
