package com.ashx.gfg.linkedlist;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    public String name;
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node(String name, T data) {
        this(data);
        this.name = name;
    }

    public void print() {
        if (StringUtils.isNoneEmpty(this.name)) {
            System.out.print(this.name + "::");
        }
        List<Node<T>> visited = new ArrayList<>();
        Node<T> curr = this;
        System.out.print(curr.data);
        visited.add(curr);
        curr = curr.next;
        while (curr != null && !visited.contains(curr)) {
            System.out.print("->" + curr.data);
            visited.add(curr);
            curr = curr.next;
        }
        if (curr != null && visited.contains(curr)) {
            System.out.print("->Looped to(" + curr.next.data + ")");
        }
        System.out.println();
    }
}
