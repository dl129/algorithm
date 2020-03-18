package com.leetcode.p3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 03. 无重复字符的最长子串
     *
     * 滑动窗口，set作为窗口，j向右遍历，如果在i向右
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}
