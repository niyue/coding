package com.niyue.coding.leetcode.minimumwindowsearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSearchTest {

	@Test
	// the order for firstEnd function is not implemented correctly
	public void testSingleCharString() {
		Solution sl = new Solution();
		String minWindow = sl.minWindow("a", "a");
		assertEquals("a", minWindow);
	}
	
	@Test
	// forget to break when finding start pointer cannot be moved forward
	public void testSameCharString() {
		Solution sl = new Solution();
		String minWindow = sl.minWindow("aa", "aa");
		assertEquals("aa", minWindow);
	}
	
	@Test
	// forget to increase running count when iterating the char array
	public void testCharString() {
		Solution sl = new Solution();
		String minWindow = sl.minWindow("bdab", "ab");
		assertEquals("ab", minWindow);
	}
	
	@Test
	// use start instead of minWindowStart and cause the failure
	public void testLongCharString() {
		Solution sl = new Solution();
		String minWindow = sl.minWindow("cabeca", "cae");
		assertEquals("eca", minWindow);
	}
}
