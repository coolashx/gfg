package com.ashx.gfg.math;

public class TrailingZerosInFactorial {
    public static void main(String[] args) {
        System.out.println(trailingZerosInFactorial(251));
        // Theta(log(n))
    }

    public static int trailingZerosInFactorial(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }
        return res;
    }
}
