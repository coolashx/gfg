package com.ashx.gfg.arrays;

public class MaxCircularSumSubarray {
    public static void main(String[] args) {
        int[] arr = {3, -4, 5, 6, -8, 7};
        System.out.println(maxCircularSumSubarray(arr));
    }

    public static int maxCircularSumSubarray(int[] arr) {
        int maxNormal = MaxSumSubarray.maxSumSubarray(arr);
        if (maxNormal < 0) {
            return maxNormal;
        }
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        int maxCircular = arrSum + MaxSumSubarray.maxSumSubarray(arr);
        return Math.max(maxNormal, maxCircular);
    }
}
