package com.niyue.coding.leetcode.reversenodesinkgroup;

import static org.junit.Assert.*;

import org.junit.Test;

import com.niyue.coding.leetcode.common.ListNode;

public class ReverseNodesInKGroupsTest {

	@Test
	// reverse doesn't use the correct ending condition
	public void testReverseEntireList() {
		Solution sl = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head = sl.reverseKGroup(head, 2);
		assertEquals(2, head.val);
		assertEquals(1, head.next.val);
	}
	
	@Test
	// prev should be set to group start instead of current
	public void testNonMultipleK() {
		Solution sl = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head = sl.reverseKGroup(head, 2);
		assertEquals(2, head.val);
		assertEquals(1, head.next.val);
		assertEquals(3, head.next.next.val);
	}
	
	@Test
	// forget to set prev.next when a group is rotated
	public void testTwoMultipleK() {
		Solution sl = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = sl.reverseKGroup(head, 2);
		assertEquals(2, head.val);
		assertEquals(1, head.next.val);
		assertEquals(4, head.next.next.val);
		assertEquals(3, head.next.next.next.val);
	}
}
