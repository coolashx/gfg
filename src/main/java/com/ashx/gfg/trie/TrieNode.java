package com.ashx.gfg.trie;

public class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd;

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        root.insert("bad");
        root.insert("bat");
        root.insert("geek");
        root.insert("geeks");
        root.insert("cat");
        root.insert("cut");
        root.insert("zoo");

        System.out.println(root.search("bat"));
        System.out.println(root.search("eek"));

        root.delete("bat");
        System.out.println(root.search("bat"));

        root.delete("geek");
        System.out.println(root.search("geek"));
        System.out.println(root.search("geeks"));
    }

    public void insert(String str) {
        TrieNode curr = this;
        for (char c : str.toCharArray()) {
            int idx = getIndex(c);
            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String str) {
        TrieNode curr = this;
        for (char c : str.toCharArray()) {
            int idx = getIndex(c);
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.isEnd;
    }

    public void delete(String str) {
        delete(this, str, 0);
    }

    private TrieNode delete(TrieNode root, String str, int i) {
        if (root == null) {
            return null;
        }
        if (i == str.length()) {
            root.isEnd = false;
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }
        int idx = getIndex(str.charAt(i));
        root.child[idx] = delete(root.child[idx], str, i + 1);
        if (isEmpty(root) && !root.isEnd) {
            root = null;
        }
        return root;
    }

    private int getIndex(char c) {
        return c - 'a';
    }

    private boolean isEmpty(TrieNode root) {
        for (TrieNode c : root.child) {
            if (c != null) {
                return false;
            }
        }
        return true;
    }
}
