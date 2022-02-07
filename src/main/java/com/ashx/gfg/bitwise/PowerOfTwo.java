package com.ashx.gfg.bitwise;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo(16));
        System.out.println(powerOfTwo(5));
    }

    public static boolean powerOfTwo(int n) {
        return n != 0 && ((n & (n - 1)) == 0);
    }
}
