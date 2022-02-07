package com.ashx.gfg.math;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        System.out.println(StringUtils.join(primeFactors(450), ' '));
    }

    public static int[] primeFactors(int n) {
        if (n <= 1) {
            return new int[0];
        }
        List<Integer> primeFactors = new ArrayList<>();
        while (n % 2 == 0) {
            primeFactors.add(2);
            n = n / 2;
        }
        while (n % 3 == 0) {
            primeFactors.add(3);
            n = n / 3;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            while (n % i == 0) {
                primeFactors.add(i);
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                primeFactors.add(i + 2);
                n = n / (i + 2);
            }
        }
        if (n > 3) {
            primeFactors.add(n);
        }
        return primeFactors.stream().mapToInt(i -> i).toArray();
    }

    private static String print(int[] arr) {
        StringBuilder buffer = new StringBuilder();
        for (int n : arr) {
            buffer.append(n).append(" ");
        }
        return buffer.toString();
    }
}
