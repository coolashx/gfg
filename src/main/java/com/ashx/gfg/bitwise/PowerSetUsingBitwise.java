package com.ashx.gfg.bitwise;

public class PowerSetUsingBitwise {
    public static void main(String[] args) {
        powerSetUsingBitwise("abc");// Theta(2^n * n)
    }

    public static void powerSetUsingBitwise(String str) {
        int n = str.length();
        double power = Math.pow(2, n);
        for (int counter = 0; counter < power; counter++) {
            for (int j = 0; j < n; j++) {
                if ((counter & (1 << j)) != 0) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
