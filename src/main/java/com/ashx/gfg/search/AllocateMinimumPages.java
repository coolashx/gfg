package com.ashx.gfg.search;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30};
        int k = 2;
        System.out.println(minPages(arr, k)); // O(n*log(sum-max))
    }

    public static int minPages(int[] arr, int k) {
        int n = arr.length;
        int sum = 0, mx = 0;
        for (int j : arr) {
            sum += j;
            mx = Math.max(mx, j);
        }
        int low = mx, high = sum, res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, n, k, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isFeasible(int[] arr, int n, int k, int ans) {
        int req = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return req <= k;
    }
}
