package com.leetcode.p200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    Deque<Integer> queue = new ArrayDeque<>();
                    queue.offer(i * col + j);
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int curX = cur / col;
                        int curY = cur % col;
                        for (int k = 0; k < directions.length; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            //使用newX newY
                            if (newX >= 0 && newX < row && newY >= 0 && newY < col
                                    && grid[newX][newY] == '1' && !visited[newX][newY]) {
                                queue.offer(newX * col + newY);
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);
    }
}

