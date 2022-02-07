package com.ashx.gfg.sorting;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 11, 3, 6, 9, 13};
        int cnt = countInver(arr, 0, arr.length - 1);
        System.out.println(cnt);
    }

    public static int countInver(int[] arr, int l, int r) {
        int res = 0;
        if (r > l) {
            int m = l + (r - l) / 2;
            res += countInver(arr, l, m);
            res += countInver(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    private static int countAndMerge(int[] arr, int low, int mid, int high) {
        int res = 0;
        int n1 = mid - low + 1, n2 = high - mid;
        int[] left = new int[n1], right = new int[n2];
        System.arraycopy(arr, low, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                res += n1 - i;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return res;
    }
}
