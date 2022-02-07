package com.ashx.gfg.bitwise;

public class OneOddOccurring {
    public static void main(String[] args) {
        int[] arr = {4, 3, 4, 4, 4, 5, 5};
        System.out.println(oneOddOccurring(arr));
    }

    public static int oneOddOccurring(int[] arr) {
        int res = 0;
        for (int j : arr) {
            res = res ^ j;
        }
        return res;
    }
}
