package com.niyue.coding.leetcode.wildcardmatching;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class WildCardMatchingTest {
	@Test
	public void testZeroLengthString() {
		Solution sl = new Solution();
		assertFalse(sl.isMatch("", "?"));
	}
}
