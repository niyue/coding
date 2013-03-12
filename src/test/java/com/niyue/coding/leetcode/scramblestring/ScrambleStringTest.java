package com.niyue.coding.leetcode.scramblestring;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScrambleStringTest {

	@Test
	// forget to initialize the class variable during each run of the function
	public void testAB() {
		Solution sl = new Solution();
		boolean isScramble = sl.isScramble("a", "b");
		assertFalse(isScramble);
	}
}
