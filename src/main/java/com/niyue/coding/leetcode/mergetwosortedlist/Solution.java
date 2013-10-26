package com.niyue.coding.leetcode.mergetwosortedlist;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_21
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else {
            ListNode head = l1.val <= l2.val ? l1 : l2;
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode prev = null;
            while(p1 != null && p2 != null) {
                ListNode small = p1.val <= p2.val ? p1 : p2;
                if(prev != null) {
                    prev.next = small;
                }
                prev = small;
                if(small == p1) {
                	p1 = p1.next;
                } else {
                	p2 = p2.next;
                }
            }

            prev.next = p1 != null ? p1 : p2;
            return head;
        }
    }
}
