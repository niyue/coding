package com.niyue.coding.leetcode.rotatelist;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_61
// Given a list, rotate the list to the right by k places, where k is non-negative.
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        ListNode headNode = head;
        int length = getLength(head);       
        if(length > 0) {
            n %= length;
            if(n > 0) {
            	ListNode fast = head;
                while(n > 0) {
                    fast = fast.next;
                    n--;
                }
                ListNode slow = head;
                while(fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                
                headNode = slow.next;
                slow.next = null;
                fast.next = head;
            }
        }
        return headNode;        
    }

    private int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
