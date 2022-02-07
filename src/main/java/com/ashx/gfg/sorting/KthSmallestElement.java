package com.ashx.gfg.sorting;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 11, 6, 26};
        int idx = kthSmallestElementIdx(arr, 5);
        System.out.println(arr[idx]);
    }

    public static int kthSmallestElementIdx(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int p = LomutoPartition.partition(arr, l, r);
            if (p == k - 1) {
                return p;
            } else if (p > k - 1) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return -1;
    }
}
