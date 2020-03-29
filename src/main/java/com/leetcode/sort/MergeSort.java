package com.leetcode.sort;

import java.util.Arrays;

class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 12, 1, 2};
        MergeSort ms = new MergeSort();
        ms.mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}