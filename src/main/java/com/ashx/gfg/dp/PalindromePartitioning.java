package com.ashx.gfg.dp;

import com.ashx.gfg.string.Palindrome;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(palPartRec("geek"));
        System.out.println(palPartDP("geek"));
    }

    public static int palPartRec(String str) {
        return palPartRec(str, 0, str.length() - 1);
    }

    private static int palPartRec(String str, int i, int j) {
        if (Palindrome.isPalindrome(str, i, j)) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            res = Math.min(res, 1
                    + palPartRec(str, i, k)
                    + palPartRec(str, k + 1, j));
        }

        return res;
    }

    public static int palPartDP(String str) { // O(n^3)
        int n = str.length();
        int[][] dp = new int[n][n];
        // dp[i][j] = Min cuts required for substring str[i..j]
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0; // Single length strings are palindrome.
            isPal[i][i] = true;
        }
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (str.charAt(i) == str.charAt(j)
                        && (isPal[i + 1][j - 1] || gap == 1)) { // Palindrome.isPalindrome(str, i, j)
                    dp[i][j] = 0;
                    isPal[i][j] = true;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    isPal[i][j] = false;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
