package com.niyue.coding.leetcode.removenthnode;

import com.niyue.coding.leetcode.common.ListNode;

//http://leetcode.com/onlinejudge#question_19
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head; // the end node
		ListNode slow = head; // the node to be removed

		while (n > 0) {
			fast = fast.next;
			n--;
		}

		ListNode prev = null;
		while (fast != null) {
			fast = fast.next;
			prev = slow;
			slow = slow.next;
		}

		if (slow == head) {
			head = slow.next;
		} else {
			prev.next = slow.next;
		}
		return head;
	}
}
