package com.niyue.coding.leetcode.partitionlist;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_86
// Partition the linked list to two lists (one for small values, one for big values), just like the partition in quick sort, and combine two lists finally
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode current = head;
        ListNode smallCursor = small;
        ListNode bigCursor = big;
        while(current != null) {
            if(current.val < x) {
                smallCursor.next = current;
                smallCursor = smallCursor.next;
            } else {
                bigCursor.next = current;
                bigCursor = bigCursor.next;
            }
            current = current.next;
        }
        small = small.next;
        big = big.next;
        bigCursor.next = null;
        smallCursor.next = null;
        if(small != null) {
        	smallCursor.next = big;    
        } else if(big != null) {
            small = big;
        }
        return small;
    }
}
