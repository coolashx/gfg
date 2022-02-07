package com.ashx.gfg.recursion;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 15};
        System.out.println(subsetSum(arr, arr.length, 25)); // Theta(2^n)
    }

    public static int subsetSum(int[] arr, int n, int sum) {
        if (n == 0) {
            return sum == 0 ? 1 : 0;
        }
        return subsetSum(arr, n - 1, sum) + subsetSum(arr, n - 1, sum - arr[n - 1]);
    }
}
