package com.ashx.gfg.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {8, 8, 6, 6, 6, 4, 6};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] arr) {
        int n = arr.length;
        
        // Find a candidate
        int res = 0, count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // Check if the candidate is actually a majority
        count = 0;
        for (int j : arr) {
            if (arr[res] == j) {
                count++;
            }
        }
        if (count <= n / 2) {
            res = -1;
        }
        return res;
    }
}
