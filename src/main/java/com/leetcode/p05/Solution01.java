package com.leetcode.p05;

public class Solution01 {
    /**
     * 1. 暴力，枚举所有的子串，判断是否是回文子串

     */
    /**
     * 1. 暴力，枚举所有的子串，判断是否是回文子串
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String maxRes = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (temp.length() > maxLen && isPalindrome(temp)) {
                    maxRes = temp;
                    maxLen = maxRes.length();
                }
            }
        }
        return maxRes;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution01 s = new Solution01();
        String res = s.longestPalindrome("babad");
        System.out.print(res);
    }
}
