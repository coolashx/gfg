package com.ashx.gfg.search;

public class RepeatingElements {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3, 5, 4, 6, 2};
        System.out.println(findRepeating(arr));
    }

    public static int findRepeating(int[] arr) {
        int slow = arr[0] + 1, fast = arr[0] + 1;
        do {
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        } while (slow != fast);

        slow = arr[0] + 1;
        while (slow != fast) {
            fast = arr[fast] + 1;
            slow = arr[slow] + 1;
        }
        return slow - 1;
    }
}
