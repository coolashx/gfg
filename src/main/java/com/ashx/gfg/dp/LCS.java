package com.ashx.gfg.dp;

import java.util.Arrays;

/**
 * Longest Common Subsequence
 */
public class LCS {
    public static void main(String[] args) {
        System.out.println(lcs("AXYZ", "BAZ"));
    }

    public static int lcs(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] memo = new int[l1 + 1][l2 + 1];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));
        return lcs(s1, s2, l1, l2, memo);
    }

    private static int lcs(String s1, String s2, int l1, int l2, int[][] memo) {
        if (memo[l1][l2] == -1) {
            if (l1 == 0 || l2 == 0) {
                memo[l1][l2] = 0;
            } else {
                if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
                    memo[l1][l2] = 1 + lcs(s1, s2, l1 - 1, l2 - 1, memo);
                } else {
                    memo[l1][l2] = Math.max(lcs(s1, s2, l1 - 1, l2, memo),
                            lcs(s1, s2, l1, l2 - 1, memo));
                }
            }
        }
        return memo[l1][l2];
    }
}
