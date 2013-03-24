package com.niyue.coding.leetcode.nqueensii;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueensIITest {

	@Test
	// the original implementation is too slow to pass the large data set (600+ms), and by using int array to replace Deque, it is 30% faster (less than 400ms)
	public void test12Queens() {
		Solution sl = new Solution();
		int count = sl.totalNQueens(12);
		assertEquals(14200, count);
	}
}
