package com.niyue.coding.leetcode.distinctsubsequences;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistinctSubsequencesTest {

	@Test
	public void testSSmallerThanT() {
		Solution sl = new Solution();
		int count = sl.numDistinct("", "a");
		assertEquals(0, count);
	}
	
	@Test
	public void testSingleCharSAndT() {
		Solution sl = new Solution();
		int count = sl.numDistinct("b", "a");
		assertEquals(0, count);
	}
	
	@Test
	public void testLongSAndT() {
		Solution sl = new Solution();
		int count = sl.numDistinct("ddd", "dd");
		assertEquals(3, count);
	}

}
