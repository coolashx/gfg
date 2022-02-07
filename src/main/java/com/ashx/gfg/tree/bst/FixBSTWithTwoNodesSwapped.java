package com.ashx.gfg.tree.bst;

import com.ashx.gfg.tree.Node;

public class FixBSTWithTwoNodesSwapped {
    public static void main(String[] args) {
        Node<Integer> root = BSTUtils.getDummyTree();
        root.left.left.data = 55;
        root.right.left.data = 35;
        Params<Integer> params = fixBST(root);
        System.out.println("First: " + params.first.data + ", Second: " + params.second.data);
    }

    public static <T extends Comparable<T>> Params<T> fixBST(Node<T> root) {
        Params<T> params = new Params<>();
        fixBST(root, params);
        return params;
    }

    public static <T extends Comparable<T>> void fixBST(Node<T> root, Params<T> params) {
        if (root == null) {
            return;
        }
        fixBST(root.left, params);
        if (params.prev != null && root.data.compareTo(params.prev.data) < 0) {
            if (params.first == null) {
                params.first = params.prev;
            }
            params.second = root;
        }
        params.prev = root;
        fixBST(root.right, params);
    }

    static class Params<T extends Comparable<T>> {
        Node<T> prev = null, first = null, second = null;
    }
}
