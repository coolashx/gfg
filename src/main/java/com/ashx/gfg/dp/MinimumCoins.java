package com.ashx.gfg.dp;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5};
        int val = 30;
        System.out.println(getMin(coins, val));
    }

    public static int getMin(int[] coins, int val) { // Theta (n * val)
        int[] dp = new int[val + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= val; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int sub_res = dp[i - coin];
                    if (sub_res != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], sub_res + 1);
                    }
                }
            }
        }

        return dp[val];
    }
}
