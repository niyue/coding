package com.niyue.coding.leetcode.reverselinkedlistii;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_92
// Reverse a linked list from position m to n. Do it in-place and in one-pass.
public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode prev = skip(head, m);
		ListNode start = prev == null ? head : prev.next;
		ListNode end = reverse(start, n - m + 1);
		if (prev != null) {
			prev.next = end;
		}
		return m == 1 ? end : head;
	}

	private ListNode skip(ListNode head, int m) {
		ListNode current = null;
		for (int i = 1; i < m; i++) {
			current = current == null ? head : current.next;
		}
		return current;
	}

	private ListNode reverse(ListNode head, int length) {
		ListNode current = head;
		ListNode prev = null;
		for (int i = 0; i < length; i++) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head.next = current;
		return prev;
	}
}
