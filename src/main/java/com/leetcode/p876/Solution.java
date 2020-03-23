package com.leetcode.p876;

class Solution {
    /**
     * 给定一个带有头结点的非空单链表，返回链表的中间节点。如果有两个中间节点，则返回第二个
     * 1、放在数组中
     * 2、遍历一遍计数，再遍历一遍
     * 3、快慢指针，快指针走两步  快指针可以前进的条件，当前快指针和当前快指针的下一节点都非空
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
