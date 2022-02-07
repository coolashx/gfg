package com.ashx.gfg.math;

public class LCM {
    public static void main(String[] args) {
        System.out.println(lcm(4, 6));
    }

    public static int lcm(int a, int b) {
        return (a * b) / GCD.gcd(a, b);
    }
}
