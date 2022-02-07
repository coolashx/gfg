package com.ashx.gfg.arrays;

import java.util.Arrays;

public class PrefixSum2 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 8, -9, 20, 6};
        System.out.println(isEqPoint(arr)); // O(n)
    }

    public static boolean isEqPoint(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int l_sum = 0;
        for (int j : arr) {
            if (l_sum == sum - j) {
                return true;
            }
            l_sum += j;
            sum -= j;
        }
        return false;
    }
}
