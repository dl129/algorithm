package com.leetcode.p70;

public class Solution1 {
    /**
     * climb(int i, int n, int[] memo) 表示我从第i阶到第n阶有多少种方法
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb(0, n, memo);
    }

    private int climb(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb(i + 1, n, memo) + climb(i + 2, n, memo);
        return memo[i];
    }
}
