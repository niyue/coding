package com.niyue.coding.leetcode.swapnodesinpair;

import com.niyue.coding.leetcode.common.ListNode;

/*
 * http://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SolutionTwo {
    public ListNode swapPairs(ListNode head) {
        ListNode one = head;
        ListNode two = one == null ? null : one.next;
        ListNode newHead = two == null ? one : two;
        ListNode tail = null;
        while(two != null) {
            ListNode nextOne = two.next;
            ListNode nextTwo = nextOne == null ? null : nextOne.next;
            if(tail != null) {
                tail.next = two;
            }
            one.next = two.next;
            two.next = one;
            tail = one;
            
            one = nextOne;
            two = nextTwo;
        }
        
        return newHead;
    }
}
