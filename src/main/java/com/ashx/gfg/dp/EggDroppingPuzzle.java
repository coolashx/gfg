package com.ashx.gfg.dp;

/**
 * <pre>
 * res (f, e) = 1 + min (max(res(x-1, e-1), res(f-x, e)))
 *                1<=x<=f   Egg breaks   Egg does not breaks
 * where f = No. of floors
 * e = No. of eggs
 * res (f, e) = returns min no. of trials required (in worst case) to find threshold floor from which egg will break.
 * </pre>
 * res(f, 1) = f
 * res(1, e) = 1
 * res(0, e) = 0
 */
public class EggDroppingPuzzle {
    public static void main(String[] args) {
        System.out.println(res(10, 3));
    }

    public static int res(int floors, int eggs) {
        int[][] dp = new int[floors + 1][eggs + 1];
        for (int e = 0; e <= eggs; e++) {
            dp[0][e] = 0; // res(0, e) = 0
            dp[1][e] = 1; // res(1, e) = 1
        }
        for (int f = 0; f <= floors; f++) {
            dp[f][1] = f; // res(f, 1) = f
        }
        for (int f = 2; f <= floors; f++) {
            for (int e = 2; e <= eggs; e++) {
                dp[f][e] = Integer.MAX_VALUE;
                for (int x = 1; x <= f; x++) {
                    dp[f][e] = Math.min(dp[f][e],
                            1 + Math.max(dp[x - 1][e - 1], dp[f - x][e]));
                }
            }
        }

        return dp[floors][eggs];
    }
}
