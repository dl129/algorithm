package com.leetcode.p15;

import java.util.*;

/**
 * 3.排序夹逼
 */
public class Solution1 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 加速1：c为非负数，就不能满足a+b+c=0了
            if (nums[i] > 0) {
                return result;
            }
            // 加速2：跳过计算过的数据，同时防止结果重复
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = -(nums[left] + nums[right]);
                if (sum == nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 加速3：跳过计算过的数据，同时防止结果重复
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }
                if (sum > nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
