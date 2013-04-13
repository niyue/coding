package com.niyue.coding.leetcode.removeduplicatesfromsortedlistii;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.niyue.coding.leetcode.common.ListNode;

public class RemoveDuplicatesFromSortedListIITest {

	@Test
	public void test112() {
		Solution sl = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		ListNode result = sl.deleteDuplicates(head);
		assertEquals(2, result.val);
		assertNull(result.next);
	}
}
