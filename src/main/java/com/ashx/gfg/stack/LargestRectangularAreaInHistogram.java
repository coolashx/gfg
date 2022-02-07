package com.ashx.gfg.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangularAreaInHistogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 1, 5, 6};
        System.out.println(longestHist(arr));
    }

    public static int longestHist(int[] arr) {
        int n = arr.length;
        Deque<Integer> s = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                int tp = s.pop();
                int curr = arr[tp] * (s.isEmpty() ? i : (i - s.peek() - 1));
                res = Math.max(res, curr);
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int tp = s.pop();
            int curr = arr[tp] * (s.isEmpty() ? n : (n - s.peek() - 1));
            res = Math.max(res, curr);
        }
        return res;
    }
}
