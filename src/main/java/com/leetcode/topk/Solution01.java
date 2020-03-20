package com.leetcode.topk;

import java.util.Arrays;

class Solution01 {

    //分治 选择
    public int[] getLeastNumbers(int[] arr, int k) {
        //判断
        if (arr.length == 0 || k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        return quickPart(arr, 0, arr.length - 1, k);
    }

    private int[] quickPart(int[] arr, int low, int high, int k) {
        int p = partition(arr, low, high);
        //terminator
        if (p == k) {
            return Arrays.copyOf(arr, k);
        }
        //分解成子问题
        return p < k ? quickPart(arr, p + 1, high, k) : quickPart(arr, low, p - 1, k);
    }

    private int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int temp = arr[i];
        while (i < j) {
            //右侧第一个小于temp的放在i
            while (i < j && arr[j] >= temp) {
                j--;
            }
            arr[i] = arr[j];
            //把第一大于的数，放在刚才的 小于temp的位置
            while (i < j && arr[i] <= temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        return i;
    }
}