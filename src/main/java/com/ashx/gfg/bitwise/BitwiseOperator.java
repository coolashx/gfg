package com.ashx.gfg.bitwise;

public class BitwiseOperator {
    public static void main(String[] args) {
        int x = 3, y = 6;
        System.out.println(x & y);

        System.out.println(x | y);

        System.out.println(x ^ y);

        int a = 1;
        System.out.println(~a);
        // int range -2^31 to 2^31 - 1
        // 2's complement representation of x = 2^32 - x
        // so ~a = 2^32 - 1 - a
        // 2^32 - 1 means 32 1's
        a = 5;
        System.out.println(~a);

        int b = 3, c = 2;
        System.out.println(b << 1); // 6 = b * 2^1
        System.out.println(b << c); // 12 = b * 2^c
        System.out.println(b << 30); // -1073741824 considering 32 bits
        System.out.println(-1 << 1); // -2
        System.out.println(-3 << 2); // -12

        // Signed right >>, leading bit is 1 for -ve and 0 for +ve
        int i = 33, j = 3;
        System.out.println(i >> 1); // 16 = i / 2^1
        System.out.println(i >> j); // 4 = i / 2^j
        System.out.println(-2 >> 1); // -1
        System.out.println(-2 >> 2); // -1

        // Unsigned right >>>, leading bit is 0 for -ve and +ve
        int k = -2;
        System.out.println(k >>> 1); // 2147483647
        System.out.println(k >>> 2); // 1073741823
    }
}
