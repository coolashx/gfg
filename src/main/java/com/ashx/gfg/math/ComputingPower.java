package com.ashx.gfg.math;

public class ComputingPower {
    public static void main(String[] args) {
        System.out.println(recursivePower(3, 19));
        System.out.println(power(3, 19));
    }

    public static int recursivePower(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int tmp = recursivePower(x, n / 2);
        tmp = tmp * tmp;
        if (n % 2 == 0) {
            return tmp;
        } else {
            return tmp * x;
        }
    }

    public static int power(int x, int n) {
        // any number n can be written as power of 2, e.g. 19 = 10011
        int res = 1;
        while (n > 0) { // looping on binary of n
            if (n % 2 != 0) {
                res = res * x; // perform only when 1 is encountered in binary of n
            }
            x = x * x;
            n = n >> 1; // same as n = n / 2
        }
        return res;
    }
}
