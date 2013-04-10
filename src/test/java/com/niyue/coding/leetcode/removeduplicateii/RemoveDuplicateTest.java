package com.niyue.coding.leetcode.removeduplicateii;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicateTest {

	@Test
	public void test11() {
		Solution sl = new Solution();
		assertEquals(2, sl.removeDuplicates(new int[] {1, 1}));
	}
}
