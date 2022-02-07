package com.ashx.gfg.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(5, 10),
                Arrays.asList(4, 9),
                Arrays.asList(6, 12)
        );
        List<Integer> merged = merge(arr);
        System.out.println(merged);
    }

    public static List<Integer> merge(List<List<Integer>> arr) {
        List<Integer> merged = new ArrayList<>();
        PriorityQueue<Params> q = new PriorityQueue<>();
        for (int i = 0; i < arr.size(); i++) {
            q.add(new Params(arr.get(i).get(0), i, 0));
        }
        while (!q.isEmpty()) {
            Params curr = q.poll();
            merged.add(curr.val);
            int arrayIdx = curr.arrayIdx, nextValIdx = curr.valIdx + 1;
            if (nextValIdx < arr.get(arrayIdx).size()) {
                q.add(new Params(arr.get(arrayIdx).get(nextValIdx), arrayIdx, nextValIdx));
            }
        }

        return merged;
    }

    static class Params implements Comparable<Params> {
        int val, arrayIdx, valIdx;

        public Params(int val, int arrayIdx, int valIdx) {
            this.val = val;
            this.arrayIdx = arrayIdx;
            this.valIdx = valIdx;
        }

        @Override
        public int compareTo(Params params) {
            return Integer.compare(this.val, params.val);
        }
    }
}
