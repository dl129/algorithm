package com.leetcode.topk;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * 最小的k个数
     * 输入整数数据arr，找出其中最小的k个数
     * 1、大顶堆  PriorityQueue默认小顶堆
     *  java中 PriorityQueue((v1,v2)->v2-v1)
     * 2、分治思想，快排，选择算法，patition 比它小的都在左边，大的都在右边，如果partition==k, 就是
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>(k, (v1, v2) -> (v2 - v1));
        for (int n : arr) {
            if (heap.size() < k) {
                heap.offer(n);
            } else if (n < heap.peek()) {
                heap.poll();
                heap.offer(n);
            }
        }
        int[] res = new int[heap.size()];
        int i = 0;
        for (int n : heap) {
            res[i++] = n;
        }
        return res;
    }
}
