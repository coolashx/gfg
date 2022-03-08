package com.ashx.gfg.segmenttree;

import java.util.Arrays;

/**
 * Size = 2 * (2^(log2 n)) - 1
 * Size will always be less than 4 * n
 * If, n = 6, size = 2 * (2^(log2 6)) - 1 = 2 * (2^3) - 1 = 15
 */
public class SegmentTree {
    private final int[] arr;
    private final int[] tree;

    public SegmentTree(int[] arr) {
        this.arr = arr;
        int n = this.arr.length;
        this.tree = new int[4 * n];
        constructSegmentTree(arr);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(Arrays.toString(tree.tree));
        System.out.println(tree.getSum(2, 3));
        System.out.println(tree.getSum(0, 2));
    }

    public int getSum(int qs, int qe) { // O(log n)
        int n = this.arr.length;
        return getSum(qs, qe, 0, n - 1, 0);
    }

    private int getSum(int qs, int qe, int ss, int se, int si) {
        if (se < qs || ss > qe) {
            return 0;
        }
        if (qs <= ss && qe >= se) {
            return tree[si];
        }
        int mid = (ss + se) / 2;
        return getSum(qs, qe, ss, mid, 2 * si + 1)
                + getSum(qs, qe, mid + 1, se, 2 * si + 2);
    }

    private void constructSegmentTree(int[] arr) { // Theta (n)
        int n = arr.length;
        constructST(0, n - 1, 0);
    }

    private int constructST(int ss, int se, int si) {
        if (ss == se) {
            tree[si] = arr[ss];
            return tree[si];
        }
        int mid = (ss + se) / 2;
        tree[si] = constructST(ss, mid, 2 * si + 1)
                + constructST(mid + 1, se, 2 * si + 2);
        return tree[si];
    }
}

