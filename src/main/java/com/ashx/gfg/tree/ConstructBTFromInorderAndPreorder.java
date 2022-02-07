package com.ashx.gfg.tree;

public class ConstructBTFromInorderAndPreorder {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtils.getDummyTree();
        int[] inorder = TreeUtils.inorder(root).stream().mapToInt(i -> i).toArray();
        int[] preorder = TreeUtils.preorder(root).stream().mapToInt(i -> i).toArray();

        Node<Integer> newRoot = constructTree(inorder, preorder);
        System.out.println(root.equals(newRoot));
    }

    public static Node<Integer> constructTree(int[] inorder, int[] preorder) {
        return constructTree(inorder, preorder,
                0, inorder.length - 1, new Index(0));
    }

    private static Node<Integer> constructTree(int[] inorder, int[] preorder,
                                               int is, int ie, Index preIdx) {
        if (is > ie) {
            return null;
        }
        Node<Integer> root = new Node<>(preorder[preIdx.idx++]);
        int inIdx = 0;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.data) {
                inIdx = i;
                break;
            }
        }
        root.left = constructTree(inorder, preorder, is, inIdx - 1, preIdx);
        root.right = constructTree(inorder, preorder, inIdx + 1, ie, preIdx);
        return root;
    }
}
