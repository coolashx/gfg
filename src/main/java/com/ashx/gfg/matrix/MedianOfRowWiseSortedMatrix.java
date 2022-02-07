package com.ashx.gfg.matrix;

import java.util.Arrays;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {{5, 10, 20, 30, 40},
                {1, 2, 3, 4, 6},
                {11, 13, 15, 17, 19}};
        System.out.println(median(mat)); // O(r * log c * log (max - min))
    }

    public static int median(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int min = mat[0][0], max = mat[0][c - 1];
        for (int i = 1; i < r; i++) {
            if (mat[i][0] < min) {
                min = mat[i][0];
            }
            if (mat[i][c - 1] > max) {
                max = mat[i][c - 1];
            }
        }
        int medPos = (r * c + 1) / 2;
        while (min < max) {
            int mid = (min + max) / 2, midPos = 0;
            for (int[] arr : mat) {
                int pos = Arrays.binarySearch(arr, mid) + 1;
                midPos += Math.abs(pos);
            }
            if (midPos < medPos) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
