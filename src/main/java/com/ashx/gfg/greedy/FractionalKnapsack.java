package com.ashx.gfg.greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] arr = {
                new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)
        };
        int W = 50;
        System.out.println(fractionalKnapsack(arr, W));
    }

    public static double fractionalKnapsack(Item[] arr, int W) {
        double res = 0.0;
        Arrays.sort(arr);

        for (Item item : arr) {
            if (item.weight <= W) {
                res += item.value;
                W -= item.weight;
            } else {
                res += item.value * (double) W / (double) item.value;
                break;
            }
        }

        return res;
    }

    static class Item implements Comparable<Item> {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item i) {
            // Need to sort in descending order
            // So i.value/i.weight - value/weight >= 0
            // i.value/i.weight >= value/weight
            // i.value * weight >= value * i.weight
            return (weight * i.value) - (value * i.weight);
        }
    }
}
