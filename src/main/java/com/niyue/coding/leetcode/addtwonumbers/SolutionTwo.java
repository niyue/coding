package com.niyue.coding.leetcode.addtwonumbers;

import com.niyue.coding.leetcode.common.ListNode;

// http://oj.leetcode.com/problems/add-two-numbers/
public class SolutionTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sum = null;
        ListNode last = null;
        
        // NOTE: consider all cases: l1/l2/carry
        while(l1 != null || l2 != null || carry != 0) {
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = value / 10;
            ListNode digit = new ListNode(value % 10);
            if(last != null) {
                last.next = digit;
            } else {
                sum = digit;
            }
            last = digit;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        return sum;
    }
}
