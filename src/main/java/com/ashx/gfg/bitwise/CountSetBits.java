package com.ashx.gfg.bitwise;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits1(5)); // Theta(total bits in n)
        System.out.println(countSetBits2(5)); // Theta(set bits count)
    }

    public static int countSetBits1(int n) {
        int res = 0;
        while (n > 0) {
            if (n % 2 != 0) { // (n & 1) == 1
                res++;
            }
            n = n / 2; // n = n >> 1
        }

        return res;
    }

    public static int countSetBits2(int n) {
        int res = 0;
        while (n > 0) {
            n = (n & (n - 1)); // one by one turning off last 1
            res++;
        }
        return res;
    }
}
