package com.leetcode.p1143;

class Solution {
    /**
     * 最长公共子序列
     * <p>
     * 解法是典型的二维动态规划，比较难的字符串都是一个思路，子序列问题，穷举不太现实
     * 1.明确dp数据的含义，dp[i][j]的含义 s[1...i] 和s[1...j]的lcs长度
     * 2.base case, 0的行和列表示空串 dp[0][...] dp[..][0] ,和空串的最长公共子序列肯定为0
     * 3.状态转移方程，套路差不多  s1和s2的每个字符，要么在要么不在，两个都在就在，有一个不在就要丢一个，然后就是指针遍历
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
