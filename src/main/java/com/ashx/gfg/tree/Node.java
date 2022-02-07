package com.ashx.gfg.tree;

import java.util.Objects;

public class Node<T extends Comparable<T>> {
    public String name;
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
    }

    public Node(String name, T data) {
        this(data);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return TreeUtils.equals(this, node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
