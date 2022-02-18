package com.ashx.gfg.recursion;

/**
 * Also check {@link com.ashx.gfg.dp.RopeCutting}
 */
public class RopeCutting {
    public static void main(String[] args) {
        System.out.println(maxPieces(23, 11, 9, 12));
        System.out.println(maxPieces(9, 2, 2, 2));
    }

    public static int maxPieces(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }

        int aPieces = maxPieces(n - a, a, b, c);
        int bPieces = maxPieces(n - b, a, b, c);
        int cPieces = maxPieces(n - c, a, b, c);

        int res = Math.max(aPieces, bPieces);
        res = Math.max(res, cPieces);

        if (res == -1) {
            return -1;
        }

        return res + 1;
    }
}
