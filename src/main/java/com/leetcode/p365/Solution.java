package com.leetcode.p365;

public class Solution {
    /**
     * ax + ay = z
     * <p>
     * xy的最大公约数，z是否为最大公约数的倍数
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }

    //辗转相除法
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

