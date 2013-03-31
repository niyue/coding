package com.niyue.coding.leetcode.dividetwointegers;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideTwoIntegersTest {

	@Test
	// Math.abs should apply when both numbers are negative numbers
	public void testMinInteger() {
		Solution sl = new Solution();
		int quotient = sl.divide(Integer.MIN_VALUE, -3);
		assertEquals(715827882, quotient);
	}
}
