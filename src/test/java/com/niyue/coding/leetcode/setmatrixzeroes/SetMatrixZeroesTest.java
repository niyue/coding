package com.niyue.coding.leetcode.setmatrixzeroes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetMatrixZeroesTest {

	@Test
	public void test2x1() {
		Solution sl = new Solution();
		int[][] matrix = new int[][] {{1}, {0}}; 
		sl.setZeroes(matrix);
		assertEquals(0, matrix[0][0]);
		assertEquals(0, matrix[1][0]);
	}
	
	@Test
	// restore column/row is not implemented correctly
	public void test1x2() {
		Solution sl = new Solution();
		int[][] matrix = new int[][] {{0, 1}}; 
		sl.setZeroes(matrix);
		assertEquals(0, matrix[0][0]);
		assertEquals(0, matrix[0][1]);
	}
	
	// Notes: two issues found when running the tests
	// 1) problem is not understood firstly, numbers should be categorized into zero/non zero instead of 0/1
	// 2) a key condition is not checked correctly, it should be "matrix[i][0] != 0 && matrix[0][j] != 0" instead of "matrix[i][0] & matrix[0][j] != 0"
}
