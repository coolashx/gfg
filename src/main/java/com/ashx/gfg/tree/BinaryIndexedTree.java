package com.ashx.gfg.tree;

/**
 * int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
 * int[] bITree = {_, 1, 3, 3, 10, 5, 11, 7, 36, 9, 19, 11, 42, 13}
 * <pre>
 *                  0  1  2  3  4   5  6   7   8  9  10  11  12  13
 *                                  0(_)
 *                    1(1)    2(3)    4(10)          8(36)
 *                            3(3)  5(5) 6(11)  9(9) 10(19) 12(42)
 *                                       7(7)        11(11) 13(13)
 * </pre>
 * parent(i) = i - (i & -i)
 * next(i) = i + (i & -i)
 */
public class BinaryIndexedTree {
    private final int[] arr;
    private final int[] bITree;

    public BinaryIndexedTree(int[] arr) {
        this.arr = arr;
        int n = this.arr.length;
        this.bITree = new int[n + 1];
        constructBITree();
    }

    private void constructBITree() {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            update(i, 0, arr[i]);
        }
    }

    private void update(int idx, int prevVal, int newVal) {
        int n = arr.length;
        int diff = newVal - prevVal;
        arr[idx] = newVal;
        idx = idx + 1;
        while (idx <= n) {
            bITree[idx] += diff;
            idx = idx + (idx & -idx);// finding next of idx
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        BinaryIndexedTree tree = new BinaryIndexedTree(arr);
        System.out.println(tree.getSum(5));
        tree.update(3, 100);
        System.out.println(tree.getSum(5));
    }

    public int getSum(int idx) {
        idx = idx + 1;
        int res = 0;
        while (idx > 0) {
            res += bITree[idx];
            idx = idx - (idx & -idx);// finding parent of idx
        }

        return res;
    }

    public void update(int idx, int newVal) {
        update(idx, arr[idx], newVal);
    }
}
