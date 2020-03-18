package com.leetcode.p05;

public class Solution {
    /**
     * p05 最长回文子串
     * <p>
     * 1. 暴力，枚举所有的子串，判断是否是回文子串
     * <p>
     * 2. 动态规划
     * p(i, j) =  true s[i,j]是回文子串
     * false s[i,j]不是回文子串
     * <p>
     * p(i, j) = p(i+1, j-1) && (s[i]==s[j] || j-i<3)
     * 当长度为2的时候 判断首尾字符
     * 长度为 1 或 2的单独处理，然后向外扩散
     * 最外层循环为子串长度
     */

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        String maxRes = "";
        int maxSize = 0;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length()) {
                    break;
                }
                dp[i][j] = len == 1 || ((len == 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j));
                if (dp[i][j] && len > maxSize) {
                    maxRes = s.substring(i, j + 1);
                    maxSize = len;
                }
            }
        }
        return maxRes;
    }
}
