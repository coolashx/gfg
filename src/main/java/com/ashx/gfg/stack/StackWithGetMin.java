package com.ashx.gfg.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithGetMin {
    public static void main(String[] args) {
        MyStack s = new MyStack().push(5).push(10).push(20).push(2).push(5).push(4);
        s.pop();
        s.pop();
        s.push(2);
        s.pop();
        s.push(1);
        s.pop();
        s.pop();
    }

    static class MyStack {
        Deque<Integer> s = new ArrayDeque<>();
        int min;

        public MyStack push(int x) {
            System.out.println("Push : " + x);
            if (s.isEmpty()) {
                setMin(x);
                s.push(x);
            } else if (x <= min) {
                s.push(2 * x - min);
                setMin(x);
            } else {
                s.push(x);
            }
            return this;
        }

        public int pop() {
            int t = s.pop();
            if (t <= min) {
                int res = min;
                System.out.println("Pop : " + res);
                setMin(2 * min - t);
                return res;
            }
            System.out.println("Pop : " + t);
            return t;
        }

        public int getMin() {
            return min;
        }

        private void setMin(int min) {
            this.min = min;
            System.out.println("Current Min : " + this.min);
        }
    }
}
