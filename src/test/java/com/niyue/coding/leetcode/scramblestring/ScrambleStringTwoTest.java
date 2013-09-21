package com.niyue.coding.leetcode.scramblestring;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScrambleStringTwoTest {

	@Test
	public void testAB() {
		SolutionTwo sl = new SolutionTwo();
		boolean isScramble = sl.isScramble("a", "b");
		assertFalse(isScramble);
	}
	
	@Test
	public void testSameString() {
		SolutionTwo sl = new SolutionTwo();
		boolean isScramble = sl.isScramble("aa", "aa");
		assertTrue(isScramble);
	}
}
