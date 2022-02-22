package com.ashx.gfg.dp;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 15};
        System.out.println(subsetSumRec(arr, 25));
        System.out.println(subsetSumDP(arr, 25));

        int[] arr1 = new int[]{2, 5, 3};
        System.out.println(subsetSumRec(arr1, 5));
        System.out.println(subsetSumDP(arr1, 5));
    }

    public static int subsetSumRec(int[] arr, int sum) { // Theta(2^n)
        return subsetSumRec(arr, arr.length, sum);
    }

    private static int subsetSumRec(int[] arr, int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        return subsetSumRec(arr, n - 1, sum)
                + subsetSumRec(arr, n - 1, sum - arr[n - 1]);
    }

    public static int subsetSumDP(int[] arr, int sum) { // Theta (n * sum)
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
