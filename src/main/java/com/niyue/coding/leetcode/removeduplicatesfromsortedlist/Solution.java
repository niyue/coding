package com.niyue.coding.leetcode.removeduplicatesfromsortedlist;

import com.niyue.coding.leetcode.common.ListNode;

/* 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * http://leetcode.com/onlinejudge#question_83
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            if(prev != null && current.val == prev.val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
