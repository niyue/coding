package com.niyue.coding.leetcode.linkedlistcycle;

import com.niyue.coding.leetcode.common.ListNode;

/*
 * http://oj.leetcode.com/problems/linked-list-cycle/
 * http://ostermiller.org/find_loop_singly_linked_list.html
 * Tortoise and hare solution
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean hasCycle = false;
        if(head != null) {
            ListNode fast = head;
            ListNode slow = head;
            while(!hasCycle && fast != null) {
                fast = fast.next;
                if(fast != slow) {
                    if(fast != null) {
                        fast = fast.next;
                        hasCycle = fast == slow;
                    }
                } else {
                    hasCycle = true;
                }
                slow = slow.next;
            }    
        } 
        return hasCycle;
    }
}
