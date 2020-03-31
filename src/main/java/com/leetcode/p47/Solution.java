package com.leetcode.p47;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, nums, new ArrayDeque<Integer>(), new int[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, Deque<Integer> stack, int[] visited) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            stack.push(nums[i]);
            visited[i] = 1;
            helper(res, nums, stack, visited);
            stack.pop();
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(nums);
    }
}
