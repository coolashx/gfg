package com.ashx.gfg.string;

import java.util.Arrays;

public class LongestSubstringWithDistinctChars {
    public static void main(String[] args) {
        System.out.println(longestDist("abcadbd"));
    }

    public static int longestDist(String str) {
        int n = str.length(), res = 0;
        int[] prev = new int[256];
        Arrays.fill(prev, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, prev[str.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res, maxEnd);
            prev[str.charAt(j)] = j;
        }
        return res;
    }
}
