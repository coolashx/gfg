package com.ashx.gfg.math;

public class Prime {
    public static void main(String[] args) {
        System.out.println(prime(5));
        // O(Sqrt(n))
    }

    public static boolean prime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i < n * n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
