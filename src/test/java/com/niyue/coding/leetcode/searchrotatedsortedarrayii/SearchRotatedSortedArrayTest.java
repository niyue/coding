package com.niyue.coding.leetcode.searchrotatedsortedarrayii;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchRotatedSortedArrayTest {

	@Test
	public void testDuplicates() {
		Solution sl = new Solution();
		assertTrue(sl.search(new int[] {1, 1, 1, 3}, 3));
	}
	
	@Test
	public void testZeroInDuplicates() {
		Solution sl = new Solution();
		assertTrue(sl.search(new int[] {2, 2, 2, 0, 2, 2}, 0));
	}
}
