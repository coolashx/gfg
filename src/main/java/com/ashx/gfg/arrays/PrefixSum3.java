package com.ashx.gfg.arrays;

public class PrefixSum3 {
    public static void main(String[] args) {
        int[] l = {1, 2, 3};
        int[] r = {3, 5, 7};
        System.out.println(maxOccur(l, r)); // O(n)
    }

    public static int maxOccur(int[] l, int[] r) {
        int[] arr = new int[1000];
        for (int i = 0; i < l.length; i++) {
            arr[l[i]]++;
            arr[r[i] + 1]--;
        }
        int maxm = arr[0], res = 0;
        for (int i = 1; i < 1000; i++) {
            arr[i] += arr[i - 1];
            if (maxm < arr[i]) {
                maxm = arr[i];
                res = i;
            }
        }
        return res;
    }
}
