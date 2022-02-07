package com.ashx.gfg.linkedlist;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>("A", 10);
        a.next = new Node<>(20);
        a.next.next = new Node<>(30);
        a.print();
        Node<Integer> b = new Node<>("B", 5);
        b.next = new Node<>(35);
        b.print();

        Node<Integer> merged = merge(a, b);
        merged.print();
    }

    public static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node<Integer> head = null, tail = null;
        if (a.data <= b.data) {
            head = tail = a;
            a = a.next;
        } else {
            head = tail = b;
            b = b.next;
        }
        head.name = "Merged";
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                tail = a;
                a = a.next;
            } else {
                tail.next = b;
                tail = b;
                b = b.next;
            }
            if (a == null) {
                tail.next = b;
            } else {
                tail.next = a;
            }
        }

        return head;
    }
}
