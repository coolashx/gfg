package com.ashx.gfg.string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        return isPalindrome(str, i, j);
    }

    public static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
