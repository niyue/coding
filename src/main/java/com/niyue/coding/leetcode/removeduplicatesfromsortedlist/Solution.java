package com.niyue.coding.leetcode.removeduplicatesfromsortedlist;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_83
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head != null) {
            ListNode prev = head;
            ListNode current = head.next;
            while(current != null) {
                if(current.val == prev.val) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }
        }
        return head;
    }
}
