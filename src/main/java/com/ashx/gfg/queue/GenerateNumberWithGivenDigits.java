package com.ashx.gfg.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateNumberWithGivenDigits {
    public static void main(String[] args) {
        printFirstN(10);
    }

    public static void printFirstN(int n) {
        Queue<String> q = new ArrayDeque<>();
        q.offer("5");
        q.offer("6");
        for (int count = 0; count < n; count++) {
            String curr = q.poll();
            System.out.print(curr + " ");
            q.offer(curr + "5");
            q.offer(curr + "6");
        }
    }
}
