package com.niyue.coding.leetcode.rotatelist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.niyue.coding.leetcode.common.ListNode;

public class RotateListTest {

	@Test
	// incorrect assumption about rotating K = length of list positions
	public void testRotateSameLengthAsList() {
		Solution sl = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head = sl.rotateRight(head, 2);
		assertEquals(1, head.val);
		assertEquals(2, head.next.val);
	}
}
