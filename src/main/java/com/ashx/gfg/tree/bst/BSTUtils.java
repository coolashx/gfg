package com.ashx.gfg.tree.bst;

import com.ashx.gfg.tree.Node;
import com.ashx.gfg.tree.TreeUtils;

public class BSTUtils extends TreeUtils {
    public static void main(String[] args) {
        Node<Integer> root = getDummyTree();
        System.out.println(inorder(root));
        Node<Integer> newRoot = deleteNode(root, 50);
        System.out.println("Tree after deleting 50: " + inorder(newRoot));

        System.out.println("Is BST: " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static <T extends Comparable<T>> Node<T> deleteNode(Node<T> root, T x) {
        if (root == null) {
            return null;
        }
        if (root.data.compareTo(x) > 0) {
            root.left = deleteNode(root.left, x);
        } else if (root.data.compareTo(x) < 0) {
            root.right = deleteNode(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node<T> successor = getSuccessor(root);
                root.data = successor.data;
                root.right = deleteNode(root.right, successor.data);
            }
        }
        return root;
    }

    private static <T extends Comparable<T>> Node<T> getSuccessor(Node<T> root) {
        Node<T> curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static <T extends Comparable<T>> boolean isBST(Node<T> root, T min, T max) {
        if (root == null) {
            return true;
        }
        return root.data.compareTo(min) > 0
                && root.data.compareTo(max) < 0
                && isBST(root.left, min, root.data)
                && isBST(root.right, root.data, max);
    }
}
