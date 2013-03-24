package com.niyue.coding.leetcode.nqueensii;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensIITest {

	@Test
	public void test12Queens() {
		Solution sl = new Solution();
		int count = sl.totalNQueens(12);
		assertEquals(14200, count);
	}
}
