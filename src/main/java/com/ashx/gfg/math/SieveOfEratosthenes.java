package com.ashx.gfg.math;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prime numbers equal of smaller of a number
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        System.out.println(StringUtils.join(sieveOfEratosthenes(9), ' '));
    }

    public static int[] sieveOfEratosthenes(int n) {
        List<Integer> lst = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                lst.add(i);
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        return lst.stream().mapToInt(z -> z).toArray();
    }
}
