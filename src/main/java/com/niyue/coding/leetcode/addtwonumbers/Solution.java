package com.niyue.coding.leetcode.addtwonumbers;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_2

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode s1 = l1;
        ListNode s2 = l2;
        ListNode result = null;
        ListNode current = null;
        // sum both list
        while(s1 != null && s2 != null) {
            int sum = s1.val + s2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            if(current == null) {
                current = new ListNode(sum);
                result = current;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
            }
            s1 = s1.next;
            s2 = s2.next;
        }
        // copy the remaining numbers in longer one
        if(s1 != null || s2 != null) {
            ListNode remaining = s1 != null ? s1 : s2;
            while(remaining != null) {
                int sum = remaining.val + carry;
                carry = sum / 10;
                sum = sum % 10;    
                current.next = new ListNode(sum);
                current = current.next;
                remaining = remaining.next;
            }
        }
        if(carry == 1) {
            current.next = new ListNode(1);    
        }
        return result;
    }
}
