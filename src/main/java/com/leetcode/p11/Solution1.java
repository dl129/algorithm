package com.leetcode.p11;

public class Solution1 {
    /**
     * 双指针，矮的一方移动
     */
    public int maxArea(int[] height) {
        if (null == height || height.length == 0) {
            return 0;
        }
        int max = 0, i = 0, j = height.length - 1;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
