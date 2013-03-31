package com.niyue.coding.leetcode.longestvalidparentheses;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestValidParenthesesTest {

	@Test
	// fail to handle this case
	public void testDoubleOpenParentheses() {
		Solution sl = new Solution();
		int length = sl.longestValidParentheses("()(()");
		assertEquals(2, length);
	}
	
	@Test
	// fail to handle this case
	public void testMultipleParentheses() {
		Solution sl = new Solution();
		int length = sl.longestValidParentheses(")()())()()(");
		assertEquals(4, length);
	}
}
