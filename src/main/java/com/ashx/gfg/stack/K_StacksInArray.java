package com.ashx.gfg.stack;

import java.util.Arrays;

public class K_StacksInArray {
    public static void main(String[] args) {
        KStacks stacks = new KStacks(3, 100);
        stacks.push(100, 0);
        stacks.push(200, 0);
        stacks.push(300, 1);
        stacks.push(400, 2);
        stacks.push(500, 0);
        stacks.push(600, 2);
        stacks.push(700, 1);

        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(2));
    }

    static class KStacks {
        int k, freeTop, cap;
        int[] arr, top, next;

        KStacks(int noOfStacks, int capacityOfArray) {
            this.k = noOfStacks;
            this.cap = capacityOfArray;
            arr = new int[cap];
            next = new int[cap];
            top = new int[k];
            Arrays.fill(top, -1);
            freeTop = 0;
            for (int i = 0; i < cap - 1; i++) {
                next[i] = i + 1;
            }
            next[cap - 1] = -1;
        }

        void push(int x, int st) {
            int i = freeTop;
            freeTop = next[i];
            next[i] = top[st];
            top[st] = i;
            arr[i] = x;
        }

        int pop(int st) {
            int i = top[st];
            top[st] = next[i];
            next[i] = freeTop;
            freeTop = i;
            return arr[i];
        }
    }
}
