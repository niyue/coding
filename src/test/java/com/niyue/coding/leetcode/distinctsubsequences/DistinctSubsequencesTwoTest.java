package com.niyue.coding.leetcode.distinctsubsequences;

import static org.junit.Assert.*;

import org.junit.Test;

public class DistinctSubsequencesTwoTest {

	@Test
	public void testSSmallerThanT() {
		SolutionTwo sl = new SolutionTwo();
		int count = sl.numDistinct("", "a");
		assertEquals(0, count);
	}
	
	@Test
	public void testSingleCharSAndT() {
		SolutionTwo sl = new SolutionTwo();
		int count = sl.numDistinct("b", "a");
		assertEquals(0, count);
	}
	
	@Test
	public void testLongSAndT() {
		SolutionTwo sl = new SolutionTwo();
		int count = sl.numDistinct("ddd", "dd");
		assertEquals(3, count);
	}

}
