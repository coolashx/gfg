package com.ashx.gfg.string;

public class KMP {
    public static void main(String[] args) {
        kmp("ababa", "ababcababaad");
    }

    public static void kmp(String pat, String txt) {
        int n = txt.length(), m = pat.length();
        int[] lps = getLPS(pat);
        int i = 0, j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.print((i - j) + " ");
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
    }

    private static int[] getLPS(String pat) {
        int n = pat.length(), len = 0;
        int[] lps = new int[n];

        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }
}
