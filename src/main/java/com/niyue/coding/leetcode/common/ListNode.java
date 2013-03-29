package com.niyue.coding.leetcode.common;


public final class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		this.val = x;
	}
	@Override
	public String toString() {
		return val + "," + next;
	}
}
