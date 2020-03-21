package com.leetcode.p365;

import java.util.*;

public class Solution01 {
    /**
     * 1、搜索  （remain_x, remain_y）两个水壶的水量，
     * 共有操作，x/y装满或清空，x中的倒到y直到x为空或y满，y中的倒到x中，直到y空或x满，有环图，需要记录visited
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        Deque<List<Integer>> queue = new ArrayDeque<>();
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> init = Arrays.asList(0, 0);
        queue.offer(init);
        visited.add(init);
        while (!queue.isEmpty()) {
            List<Integer> tup = queue.poll();
            Integer curX = tup.get(0);
            Integer curY = tup.get(1);
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }
            List<List<Integer>> nextTupList = getNextTupList(curX, curY, x, y);
            for (List<Integer> next : nextTupList) {
                if (!visited.contains(next)) {
                    queue.offerLast(next);
                    visited.add(next);
                }
            }

        }
        return false;
    }

    private List<List<Integer>> getNextTupList(int curX, int curY, int x, int y) {
        List<List<Integer>> list = new ArrayList<>(6);
        //x倒满
        list.add(Arrays.asList(x, curY));
        //x清空
        list.add(Arrays.asList(0, curY));
        //y倒满
        list.add(Arrays.asList(curX, y));
        //y清空
        list.add(Arrays.asList(curX, 0));
        //x->y
        int diffX = Math.min(curX, y - curY);
        list.add(Arrays.asList(curX - diffX, curY + diffX));
        //y->x
        int diffY = Math.min(curY, x - curX);
        list.add(Arrays.asList(curX + diffY, curY - diffY));
        return list;
    }
}
