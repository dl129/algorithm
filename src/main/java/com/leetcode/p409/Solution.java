package com.leetcode.p409;

public class Solution {
    /**
     *  构造的最长回文子串长度
     *
     * 出现偶数次的，一定全用了，奇数的里面的偶数也用了，最后如果有奇数，要加一
     *
     */
    public int longestPalindrome(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int[] countArr = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            countArr[s.charAt(i)]++;
        }
        int ans = 0;
        for (int count : countArr) {
            ans += count / 2 * 2;
        }
        return ans < len ? ans + 1 : ans;
    }
}
