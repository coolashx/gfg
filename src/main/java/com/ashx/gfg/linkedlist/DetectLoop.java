package com.ashx.gfg.linkedlist;

public class DetectLoop {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(10);
        Node<Integer> loopStart = new Node<>(12);
        head.next = loopStart;
        head.next.next = new Node<>(15);
        head.next.next.next = new Node<>(20);
        head.next.next.next.next = new Node<>(25);
        head.next.next.next.next.next = loopStart;

        head.print();

        System.out.println(detectLoop(head));
    }

    public static boolean detectLoop(Node<Integer> head) {
        Node<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
