package com.ashx.gfg.linkedlist;

public class DoublyNode<T> extends Node<T> {
    public Node<T> prev;

    public DoublyNode(T data) {
        super(data);
    }

    public DoublyNode(Node<T> prev, T data) {
        super(data);
        this.prev = prev;
        prev.next = this;
    }

    public DoublyNode(String name, T data) {
        super(name, data);
    }

    public DoublyNode(String name, Node<T> prev, T data) {
        super(name, data);
        this.prev = prev;
        prev.next = this;
    }
}
