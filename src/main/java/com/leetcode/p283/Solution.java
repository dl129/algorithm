package com.leetcode.p283;

public class Solution {
    /**
     给定一个数组，将所有0移到数组最后，非零元素相对顺序不变
     1、双指针，j向后移动，不为0，将元素换到i
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (j != i) {
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
