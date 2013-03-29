package com.niyue.coding.leetcode.mergeksortedlists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.niyue.coding.leetcode.common.ListNode;

public class MergeKSortedListsTest {

	@Test
	// cannot handle null list
	public void testOneEmptyList() {
		Solution sl = new Solution();
		ListNode head = null;
		ListNode list = sl.mergeKLists(new ArrayList<ListNode>(
				Arrays.asList(head)
		));
		assertNull(list);
	}
	
	@Test
	// PriorityQueue needs a comparator for comparison
	public void testTwoSimpleLists() {
		Solution sl = new Solution();
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(1);
		ListNode list = sl.mergeKLists(new ArrayList<ListNode>(
				Arrays.asList(one, two)
		));
		assertEquals(0, list.val);
		assertEquals(1, list.next.val);
		assertNull(list.next.next);
	}
	
	@Test
	// forget to add element to queue in one branch
	public void testOneList() {
		Solution sl = new Solution();
		ListNode one = new ListNode(0);
		one.next = new ListNode(2);
		ListNode list = sl.mergeKLists(new ArrayList<ListNode>(
				Arrays.asList(one)
		));
		assertEquals(0, list.val);
		assertEquals(2, list.next.val);
	}
}
