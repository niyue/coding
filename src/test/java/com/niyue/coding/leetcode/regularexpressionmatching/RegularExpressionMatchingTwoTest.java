package com.niyue.coding.leetcode.regularexpressionmatching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegularExpressionMatchingTwoTest {
	@Test
	public void testMatchSingleCharWithStar() {
		SolutionTwo sl = new SolutionTwo();
		boolean isMatch = sl.isMatch("a", "a*");
		assertTrue(isMatch);
	}
	
	@Test
	// i < maxMatch => i <= maxMatch
	public void testStar() {
		SolutionTwo sl = new SolutionTwo();
		boolean isMatch = sl.isMatch("aa", "a*");
		assertTrue(isMatch);
	}
	
	@Test
	// i < s.length => i <= s.length
	public void testDotStar() {
		SolutionTwo sl = new SolutionTwo();
		boolean isMatch = sl.isMatch("aa", ".*");
		assertTrue(isMatch);
	}
	
	@Test
	// an edge case
	public void testZeroLengthStar() {
		SolutionTwo sl = new SolutionTwo();
		boolean isMatch = sl.isMatch("a", "ab*");
		assertTrue(isMatch);
	}
	
	@Test
	// another edge case
	public void testDotStarChar() {
		SolutionTwo sl = new SolutionTwo();
		boolean isMatch = sl.isMatch("ab", ".*c");
		assertFalse(isMatch);
	}
}
