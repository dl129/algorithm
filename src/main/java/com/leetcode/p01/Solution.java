package com.leetcode.p01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和target，找出和为target的数组下标
 *  1.暴力 循环
 *  2.hash表
 *
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //用hash表
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }
}
