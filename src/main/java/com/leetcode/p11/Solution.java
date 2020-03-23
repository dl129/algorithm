package com.leetcode.p11;

public class Solution {
    /**
     *  盛水最多的容器
     *  1.暴力
     *  2.双指针
     *
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }
}
