package com.ashx.gfg.recursion;

import org.apache.commons.lang3.ArrayUtils;

public class Permutations {
    public static void main(String[] args) {
        permutations("ABCD".toCharArray(), 0);
    }

    public static void permutations(char[] s, int i) {
        if (i == s.length - 1) {
            System.out.println("'" + String.valueOf(s) + "'");
            return;
        }
        for (int j = i; j < s.length; j++) {
            ArrayUtils.swap(s, i, j);
            permutations(s, i + 1);
            ArrayUtils.swap(s, i, j);
        }
    }
}
