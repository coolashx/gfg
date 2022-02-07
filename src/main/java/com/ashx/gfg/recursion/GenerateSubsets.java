package com.ashx.gfg.recursion;

public class GenerateSubsets {
    public static void main(String[] args) {
        subsets("ABC", "", 0);
    }

    public static void subsets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.print("'" + curr + "' ");
            return;
        }
        subsets(s, curr, i + 1);
        subsets(s, curr + s.charAt(i), i + 1);
    }
}
