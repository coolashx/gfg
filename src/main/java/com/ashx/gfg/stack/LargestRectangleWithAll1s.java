package com.ashx.gfg.stack;

public class LargestRectangleWithAll1s {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 1, 1},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}};
        System.out.println(maxRectangle(mat));
    }

    public static int maxRectangle(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int res = LargestRectangularAreaInHistogram.longestHist(mat[0]);
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
            res = Math.max(res, LargestRectangularAreaInHistogram.longestHist(mat[i]));
        }

        return res;
    }
}
