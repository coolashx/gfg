package com.ashx.gfg.deque;

import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = {20, 40, 30, 10, 60};
        printMax(arr, 3);
    }

    public static void printMax(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for (int i = k; i < n; i++) {
            System.out.print(arr[dq.peek()] + " ");
            while (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.print(arr[dq.peek()] + " ");
    }
}
