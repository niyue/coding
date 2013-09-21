package com.niyue.coding.leetcode.partitionlist;

import com.niyue.coding.leetcode.common.ListNode;

/*
 * http://oj.leetcode.com/problems/partition-list/
 * A slightly longer but easier understandable solution
 */
public class SolutionTwo {
	public ListNode partition(ListNode head, int x) {
		ListNode lessHead = null;
		ListNode lessTail = null;
		ListNode current = head;
		ListNode greaterHead = null;
		ListNode greaterTail = null;
		while (current != null) {
			if (current.val < x) {
				if (lessHead == null) {
					lessHead = current;
				}
				if (lessTail != null) {
					lessTail.next = current;
				}
				lessTail = current;
			} else {
				if (greaterHead == null) {
					greaterHead = current;
				}
				if (greaterTail != null) {
					greaterTail.next = current;
				}
				greaterTail = current;
			}
			current = current.next;
		}
		if (lessHead == null) {
			lessHead = greaterHead;
		} else {
			lessTail.next = greaterHead;
			if (greaterTail != null) {
				greaterTail.next = null;
			}
		}
		return lessHead;
	}
}
