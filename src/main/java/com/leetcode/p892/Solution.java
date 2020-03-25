package com.leetcode.p892;

public class Solution {
    /**
     * 1 2
     * 3 4
     * 顶和底 ans += 2
     * 侧面积 相邻位置小于v的时候会贡献面积，max(v-nv, 0)
     */
    public int surfaceArea(int[][] grid) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        int len = grid.length;
        int ans = 0;
        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                if (grid[x][y] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        int nv = 0;
                        if (nx >= 0 && nx < len && ny >= 0 && ny < len) {
                            nv = grid[nx][ny];
                        }
                        ans += Math.max(grid[x][y] - nv, 0);
                    }
                }
            }
        }
        return ans;
    }
}
