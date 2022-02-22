package com.ashx.gfg.dp;

import org.apache.commons.math3.util.CombinatoricsUtils;

/**
 * <pre>
 *     res(n) = res(0)*res(n-1) + res(1)*res(n-2) + ... + res(n-1)*res(0)
 *     res(n) = SUM(res(i)*res(n-i-1)), where 0 <= i <= n-1
 *     res(0) = 1
 * </pre>
 */
public class CountBSTsWithNKeys {
    public static void main(String[] args) {
        System.out.println(countBST(5));
        System.out.println(countBSTFormula(5));
    }

    public static int countBST(int n) { // O(n^2)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    /**
     * res(n) = 2nCn / (n+1)
     *
     * @param n No. of nodes
     * @return No. of BSTs formed
     */
    public static int countBSTFormula(int n) { // O(1)
        return (int) CombinatoricsUtils.binomialCoefficient(2 * n, n) / (n + 1);
    }
}
