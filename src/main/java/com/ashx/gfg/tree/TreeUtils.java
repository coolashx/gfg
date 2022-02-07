package com.ashx.gfg.tree;

import java.util.*;

public class TreeUtils {
    public static void main(String[] args) {
        Node<Integer> root = getDummyTree();

        System.out.println("Inorder: " + inorder(root));
        System.out.println("Preorder: " + preorder(root));
        System.out.println("Postorder: " + postorder(root));
        System.out.println("Height: " + height(root));
        System.out.println("Level: " + level(root));
        System.out.print("LevelOrderLine:\n" + levelOrderLine(root));
        System.out.println("Size: " + size(root));

        List<Integer> serializeArray = serialize(root);
        System.out.println("Serialize: " + serializeArray);
        Node<Integer> deserializeNode = deserialize(serializeArray);
        System.out.println("Deserialize Node Same?: " + root.equals(deserializeNode));
    }

    public static Node<Integer> getDummyTree() {
        Node<Integer> root = new Node<>("A", 50);
        root.left = new Node<>(40);
        root.right = new Node<>(60);
        root.left.left = new Node<>(35);
        root.left.right = new Node<>(45);
        root.right.left = new Node<>(55);
        root.right.right = new Node<>(65);
        return root;
    }

    public static <T extends Comparable<T>> List<T> inorder(Node<T> root) {
        List<T> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private static <T extends Comparable<T>> void inorder(Node<T> root, List<T> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }

    public static <T extends Comparable<T>> List<T> preorder(Node<T> root) {
        List<T> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private static <T extends Comparable<T>> void preorder(Node<T> root, List<T> list) {
        if (root != null) {
            list.add(root.data);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    public static <T extends Comparable<T>> List<T> postorder(Node<T> root) {
        List<T> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private static <T extends Comparable<T>> void postorder(Node<T> root, List<T> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.data);
        }
    }

    public static <T extends Comparable<T>> int height(Node<T> root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    public static <T extends Comparable<T>> List<T> level(Node<T> root) {
        List<T> list = new ArrayList<>();
        if (root != null) {
            Queue<Node<T>> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node<T> curr = q.poll();
                list.add(curr.data);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return list;
    }

    public static <T extends Comparable<T>> String levelOrderLine(Node<T> root) {
        StringBuilder buffer = new StringBuilder();
        if (root != null) {
            Queue<Node<T>> q = new ArrayDeque<>();
            q.add(root);
            while (!q.isEmpty()) {
                int count = q.size();
                for (int i = 0; i < count; i++) {
                    Node<T> curr = q.poll();
                    assert curr != null;
                    buffer.append(curr.data).append(" ");
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

    public static <T extends Comparable<T>> int size(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    public static boolean equals(Node<?> a, Node<?> b) {
        /*1. both empty */
        if (a == null && b == null) {
            return true;
        }
        /* 2. both non-empty -> compare them */
        if (a != null && b != null) {
            return Objects.equals(a.data, b.data)
                    && equals(a.left, b.left)
                    && equals(a.right, b.right);
        }

        /* 3. one empty, one not -> false */
        return false;
    }

    public static <T extends Comparable<T>> List<T> serialize(Node<T> root) {
        List<T> arr = new ArrayList<>();
        serialize(root, arr);
        return arr;
    }

    private static <T extends Comparable<T>> void serialize(Node<T> root, List<T> arr) {
        if (root == null) {
            arr.add(null);
            return;
        }
        arr.add(root.data);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    public static <T extends Comparable<T>> Node<T> deserialize(List<T> arr) {
        return deserialize(arr, new Index(0));
    }

    private static <T extends Comparable<T>> Node<T> deserialize(List<T> arr, Index index) {
        if (index.idx == arr.size()) {
            return null;
        }
        T val = arr.get(index.idx);
        index.idx++;
        if (val == null) {
            return null;
        }
        Node<T> root = new Node<>(val);
        root.left = deserialize(arr, index);
        root.right = deserialize(arr, index);
        return root;
    }
}
