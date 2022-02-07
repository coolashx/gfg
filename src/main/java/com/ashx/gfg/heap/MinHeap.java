package com.ashx.gfg.heap;

import org.apache.commons.lang3.ArrayUtils;

/**
 * {@link java.util.PriorityQueue}() default implement MinHeap functionality.<br/>
 * {@link java.util.PriorityQueue}({@link java.util.Collections#reverseOrder()})
 * implement MaxHeap functionality.
 */
public class MinHeap {
    private int[] arr;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public int left(int idx) {
        return 2 * idx + 1;
    }

    public int right(int idx) {
        return 2 * idx + 2;
    }

    public int parent(int idx) {
        return (idx - 1) / 2;
    }

    public void insert(int element) { // h = height; O(h) = O(log n)
        if (size == capacity) {
            return;
        }
        size++;
        arr[size - 1] = element;
        for (int i = size - 1; i != 0 && arr[parent(i)] > arr[i]; i = parent(i)) {
            ArrayUtils.swap(arr, i, parent(i));
        }
    }

    public void minHeapify(int idx) { // h = height; O(h) = O(log n)
        int lt = left(idx), rt = right(idx);
        int smallest = idx;
        if (lt < size && arr[lt] < arr[idx]) {
            smallest = lt;
        }
        if (rt < size && arr[rt] < arr[smallest]) {
            smallest = rt;
        }
        if (smallest != idx) {
            ArrayUtils.swap(arr, idx, smallest);
            minHeapify(smallest);
        }
    }

    public int extractMin() { // h = height; O(h) = O(log n)
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        ArrayUtils.swap(arr, 0, size - 1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    public void decreaseKey(int idx, int element) { // h = height; O(h) = O(log n)
        arr[idx] = element;
        while (idx != 0 && arr[parent(idx)] > arr[idx]) {
            ArrayUtils.swap(arr, idx, parent(idx));
            idx = parent(idx);
        }
    }

    public void delete(int idx) { // h = height; O(h) = O(log n)
        decreaseKey(idx, Integer.MIN_VALUE);
        extractMin();
    }

    public void buildHeap() {
        /*
        From last internal node till root.
        last internal node idx = parent(lastNode)
        lastNode idx = size - 1;
        last internal node idx = parent(size - 1)
        last internal node idx = ((size - 1) - 1) / 2 = (size - 2) / 2
         */
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }
}
