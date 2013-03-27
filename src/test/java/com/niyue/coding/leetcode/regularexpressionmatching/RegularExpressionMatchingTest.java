package com.niyue.coding.leetcode.regularexpressionmatching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegularExpressionMatchingTest {

	@Test
	// i < maxMatch => i <= maxMatch
	public void testStar() {
		Solution sl = new Solution();
		boolean isMatch = sl.isMatch("aa", "a*");
		assertTrue(isMatch);
	}
	
	@Test
	// i < s.length => i <= s.length
	public void testDotStar() {
		Solution sl = new Solution();
		boolean isMatch = sl.isMatch("aa", ".*");
		assertTrue(isMatch);
	}
	
	@Test
	// an edge case
	public void testZeroLengthStar() {
		Solution sl = new Solution();
		boolean isMatch = sl.isMatch("a", "ab*");
		assertTrue(isMatch);
	}
	
	@Test
	// another edge case
	public void testDotStarChar() {
		Solution sl = new Solution();
		boolean isMatch = sl.isMatch("ab", ".*c");
		assertFalse(isMatch);
	}
}
