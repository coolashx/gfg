package com.ashx.gfg.search;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(4));
        System.out.println(sqrt(10));
        System.out.println(sqrt(27));
    }

    public static int sqrt(int x) {
        int low = 1, high = x, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int mSq = mid * mid;
            if (mSq == x) {
                return mid;
            } else if (mSq > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
