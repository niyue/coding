package com.niyue.coding.leetcode.sortedlisttobst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.niyue.coding.leetcode.common.ListNode;
import com.niyue.coding.leetcode.common.TreeNode;

public class SortedListToBstTest {

	@Test
	public void testLinkedListToBstSingleElement() {
		ListNode list = newLinkedList(1);
		Solution sl = new Solution();
		TreeNode root = sl.sortedListToBST(list);
		assertEquals(1, root.val);
		assertNull(root.left);
		assertNull(root.right);
	}
	
	@Test
	public void testLinkedListToBstTwoElements() {
		ListNode list = newLinkedList(1, 2);
		Solution sl = new Solution();
		TreeNode root = sl.sortedListToBST(list);
		assertEquals(1, root.val);
		assertEquals(2, root.right.val);
		assertNull(root.left);
	}
	
	@Test
	// stupid mistake, Java is pass-by-value, "node = node.next" doesn't advance the cursor at all
	public void testLinkedListToBst123() {
		ListNode list = newLinkedList(1, 2, 3);
		Solution sl = new Solution();
		TreeNode root = sl.sortedListToBST(list);
		assertEquals(2, root.val);
		assertEquals(1, root.left.val);
		assertEquals(3, root.right.val);
	}
	
	private ListNode newLinkedList(int... values) {
		ListNode head = null;
		ListNode prev = null;
		for(int v : values) {
			ListNode current = new ListNode(v);
			if(head == null) {
				head = current;
			}
			if(prev != null) {
				prev.next = current;
			}
			prev = current;
		}
		return head;
	}
}
