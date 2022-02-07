package com.ashx.gfg.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(4, 'A', 'B', 'C');// 2^n - 1
    }

    public static void towerOfHanoi(int n, char t1, char t2, char t3) {
        if (n == 1) {
            System.out.println("Move 1 from " + t1 + " to " + t3);
            return;
        }
        towerOfHanoi(n - 1, t1, t3, t2);
        System.out.println("Move " + n + " from " + t1 + " to " + t3);
        towerOfHanoi(n - 1, t2, t1, t3);
    }
}
