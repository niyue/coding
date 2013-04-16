package com.niyue.coding.leetcode.stringtointeger;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

	@Test
	public void testOverflowedMaxInteger() {
		Solution sl = new Solution();
		int number = sl.atoi("2147483648");
		assertEquals(2147483647, number);
	}
}
