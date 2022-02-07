package com.ashx.gfg.arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] price = {1, 5, 3, 8, 12};
        System.out.println(stockBuyAndSell1(price));
        System.out.println(maxProfit2(price));
    }

    public static int stockBuyAndSell1(int[] price) {
        return maxProfit1(price, 0, price.length - 1);
    }

    private static int maxProfit1(int[] price, int start, int end) {
        if (end <= start) {
            return 0;
        }
        int profit = 0;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr_profit = price[j] - price[i]
                            + maxProfit1(price, start, i - 1)
                            + maxProfit1(price, j + 1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    public static int maxProfit2(int[] price) {
        int profit = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                profit += (price[i] - price[i - 1]);
            }
        }
        return profit;
    }
}
