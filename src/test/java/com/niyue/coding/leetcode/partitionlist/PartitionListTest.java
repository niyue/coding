package com.niyue.coding.leetcode.partitionlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.niyue.coding.leetcode.common.ListNode;

public class PartitionListTest {

	@Test
	// fail to consider there may be a next reference doesn't set to null after iterating all nodes
	public void testTwoElements() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		Solution sl = new Solution();
		ListNode list = sl.partition(head, 2);
		assertEquals(1, list.val);
		assertEquals(2, list.next.val);
		assertNull(list.next.next);
	}
	
	@Test
	// use the incorrect cursor (should use the tail cursor instead of the head cursor) when link the small value list to the big value list
	public void testTwoSameElements() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		Solution sl = new Solution();
		ListNode list = sl.partition(head, 2);
		assertEquals(1, list.val);
		assertEquals(1, list.next.val);
		assertNull(list.next.next);
	}
}
