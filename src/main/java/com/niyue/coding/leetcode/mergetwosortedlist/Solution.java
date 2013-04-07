package com.niyue.coding.leetcode.mergetwosortedlist;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_21
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2 == null) {
            return l1;
        } else if(l1 == null) {
            return l2;
        } else {
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode head = null;
            ListNode prev = null;
            while(p1 != null && p2 != null) {
                ListNode current = p1.val <= p2.val ? p1 : p2;
                if(prev != null) {
                    prev.next = current;
                }
                prev = current;
                current = current.next;

                if(p1.val <= p2.val) {
                    p1 = current;
                } else {
                    p2 = current;   
                }

                if(head == null) {
                    head = prev;
                }
            }

            prev.next = p1 != null ? p1 : p2;
            return head;
        }
    }
}
