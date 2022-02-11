package com.ashx.gfg.greedy;

import java.util.PriorityQueue;

public class Huffman {
    private static final char INTERMEDIATE_CHAR = '$';

    public static void main(String[] args) {
        char[] arr = {'a', 'd', 'e', 'f'};
        int[] freq = {30, 40, 80, 60};

        Node root = getHuffmanTree(arr, freq);
        printHuffmanTree(root, "");
    }

    public static Node getHuffmanTree(char[] arr, int[] freq) { // O(n * log n)
        PriorityQueue<Node> h = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) { // O(n * log n)
            h.add(new Node(arr[i], freq[i]));
        }
        while (h.size() > 1) { // O(n * log n)
            Node l = h.poll();
            Node r = h.poll();
            assert r != null;
            h.add(new Node(INTERMEDIATE_CHAR, l.freq + r.freq, l, r));
        }

        return h.peek();
    }

    private static void printHuffmanTree(Node root, String s) { // Theta(n)
        if (root.ch != INTERMEDIATE_CHAR) {
            System.out.println(root.ch + ":" + s);
            return;
        }
        printHuffmanTree(root.left, s + "0");
        printHuffmanTree(root.right, s + "1");
    }

    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left, right;

        public Node(char ch, int freq) {
            this(ch, freq, null, null);
        }

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(freq, n.freq);
        }
    }
}
