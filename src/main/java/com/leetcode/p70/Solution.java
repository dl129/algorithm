package com.leetcode.p70;

public class Solution {
    /**
     * 动态规划 dp[n]到达第n阶的方法总和  dp[i] = dp[i-1] + dp[i-2]
     *
     */
    public int climbStairs(int n) {
        //动态规划
        if(n<2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
