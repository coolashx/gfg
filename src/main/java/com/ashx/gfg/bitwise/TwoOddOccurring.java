package com.ashx.gfg.bitwise;

import org.apache.commons.lang3.StringUtils;

public class TwoOddOccurring {
    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 4, 5, 4, 4, 6, 7, 7};
        System.out.println(StringUtils.join(twoOddOccurring(arr), ' '));
    }

    public static int[] twoOddOccurring(int[] arr) {
        int xor = 0, res1 = 0, res2 = 0;
        for (int k : arr) {
            xor = xor ^ k;
        }
        int sb = xor & -xor; // Rightmost set bit

        for (int k : arr) {
            if ((k & sb) != 0) {
                res1 = res1 ^ k;
            } else {
                res2 = res2 ^ k;
            }
        }

        return new int[]{res1, res2};
    }
}
