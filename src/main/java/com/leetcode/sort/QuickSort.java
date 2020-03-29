package com.leetcode.sort;

import java.util.*;

class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 12, 1, 2};
        QuickSort qs = new QuickSort();
        qs.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int privot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= privot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= privot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = privot;
        return i;
    }
}