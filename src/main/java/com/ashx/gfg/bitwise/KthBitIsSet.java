package com.ashx.gfg.bitwise;

public class KthBitIsSet {
    public static void main(String[] args) {
        kthBitIsSet(13, 3);
    }

    public static void kthBitIsSet(int n, int k) {
        if ((n & (1 << (k - 1))) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        if ((n >> (k - 1) & 1) != 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
