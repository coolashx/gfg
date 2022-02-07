package com.ashx.gfg.recursion;

public class Josephus {
    public static void main(String[] args) {
        System.out.println(josephus(5, 3)); // Theta(n)
    }

    public static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }
}
