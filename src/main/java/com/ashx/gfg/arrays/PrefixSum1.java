package com.ashx.gfg.arrays;

public class PrefixSum1 {
    public static void main(String[] args) {
        int[] arr = {2, 8, 3, 9, 6, 5, 4};
        PrefixSum1 ps = new PrefixSum1(arr);
        System.out.println(ps.getSum(0, 2)); // O(1)
        System.out.println(ps.getSum(1, 3)); // O(1)
        System.out.println(ps.getSum(2, 6)); // O(1)
    }

    int[] prefixSum;

    public PrefixSum1(int[] arr) {
        prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    private int getSum(int l, int r) {
        if (l != 0) {
            return prefixSum[r] - prefixSum[l - 1];
        } else {
            return prefixSum[r];
        }
    }
}
