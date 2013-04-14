package com.niyue.coding.leetcode.swapnodesinpair;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_24
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode pair = head;
        ListNode prev = null;
        if(head != null && head.next != null) {
            head = head.next;
        }
        while(pair != null) {
            ListNode first = pair;
            ListNode second = pair.next;
            if(second != null) {
                if(prev != null) {
                    prev.next = second;
                }
                first.next = second.next;
                second.next = first;
                pair = first.next;
                prev = first;
            } else {
                break;
            }
        }        
        return head;
    }
}
