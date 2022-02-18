package com.ashx.gfg.dp;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";
        System.out.println(eD_Rec(s1, s2));
        System.out.println(eD_DP(s1, s2));
    }

    public static int eD_DP(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) { // if (l1 == 0) return l2; -- from eDRec()
            dp[i][0] = i;
        }
        for (int j = 1; j <= l2; j++) { // if (l2 == 0) return l1; -- from eDRec()
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1],
                                    dp[i - 1][j - 1]));
                }
            }
        }
        return dp[l1][l2];
    }

    public static int eD_Rec(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        return eDRec(s1, s2, l1, l2);
    }

    private static int eDRec(String s1, String s2, int l1, int l2) {
        if (l1 == 0) {
            return l2;
        }
        if (l2 == 0) {
            return l1;
        }
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            return eDRec(s1, s2, l1 - 1, l2 - 1);
        } else {
            return 1 + Math.min(eDRec(s1, s2, l1 - 1, l2),
                    Math.min(eDRec(s1, s2, l1, l2 - 1),
                            eDRec(s1, s2, l1 - 1, l2 - 1)));
        }
    }
}
