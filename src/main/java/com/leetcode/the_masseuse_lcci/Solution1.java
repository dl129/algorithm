package com.leetcode.the_masseuse_lcci;

public class Solution1 {
    /**
     * dp[i] 表示从0到i的最大时长
     * i这一天 分两种讨论
     * 接受预约   dp[i-1]包含了昨天有预约的情况，从dp[i-2]来 dp[i-2]+nums[i]
     * 不接受预约 ,昨天既可以休息也可以不休息 dp[i-1]
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
