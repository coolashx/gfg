package com.ashx.gfg.math;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AllDivisorsOfNumber {
    public static void main(String[] args) {
        System.out.println(StringUtils.join(allDivisorsOfNumber(15), ' '));
    }

    public static int[] allDivisorsOfNumber(int n) {
        List<Integer> divisors = new ArrayList<>();
        int i;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        for (; i >= 1; i--) {
            if (n % i == 0) {
                divisors.add(n / i);
            }
        }

        return divisors.stream().mapToInt(j -> j).toArray();
    }
}
