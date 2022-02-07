package com.ashx.gfg.tree.bst;

import com.ashx.gfg.tree.Node;

import java.util.*;

public class VerticalTraversalOfBST {
    public static void main(String[] args) {
        Node<Integer> root = BSTUtils.getDummyTree();
        Map<Integer, List<Integer>> mp = verticalOrder(root);
        System.out.println("Vertical Order: " + mp.values());
        System.out.println("Top View: " + Arrays.toString(topViewOfBST(root)));
        System.out.println("Bottom View: " + Arrays.toString(bottomViewOfBST(root)));
    }

    public static Map<Integer, List<Integer>> verticalOrder(Node<Integer> root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node<Integer> curr = p.node;
            int hd = p.hd;
            mp.compute(hd, (k, lst) -> {
                if (lst == null) {
                    lst = new ArrayList<>();
                }
                lst.add(curr.data);
                return lst;
            });
            if (curr.left != null) {
                q.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, hd + 1));
            }
        }
        return mp;
    }

    public static int[] topViewOfBST(Node<Integer> root) {
        Map<Integer, List<Integer>> mp = verticalOrder(root);
        return mp.values().stream().mapToInt(lst -> lst.get(0)).toArray();
    }

    public static int[] bottomViewOfBST(Node<Integer> root) {
        Map<Integer, List<Integer>> mp = verticalOrder(root);
        return mp.values().stream().mapToInt(lst -> lst.get(lst.size() - 1)).toArray();
    }

    static class Pair {
        Node<Integer> node;
        int hd;

        Pair(Node<Integer> n, int h) {
            this.node = n;
            this.hd = h;
        }
    }
}
