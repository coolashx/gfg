package com.ashx.gfg.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        Activity[] arr = {
                new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)
        };
        System.out.println(maxActivity(arr));
    }

    public static int maxActivity(Activity[] arr) {
        int res = 1, prev = 0;
        Arrays.sort(arr, new MyCmp());
        for (int curr = 1; curr < arr.length; curr++) {
            if (arr[curr].start >= arr[prev].finish) {
                res++;
                prev = curr;
            }
        }

        return res;
    }

    static class Activity {
        int start;
        int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static class MyCmp implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.finish, a2.finish);
        }
    }
}
