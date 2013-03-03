package com.niyue.coding.leetcode.surroundedregions;

import static org.junit.Assert.*;

import org.junit.Test;

public class SurroundedRegionsTest {

	@Test
	// cannot handle one dimensional case
	public void testOneDimensionalBoard() {
		char[][] board = new char[][] {
				{'X'}
		};
		Solution sl = new Solution();
		sl.solve(board);
		assertEquals('X', board[0][0]);
	}
	
	@Test
	// forget to initialize 'surrounded' array at first 
	public void testAllO() {
		char[][] board = new char[][] {
				{'O', 'O'},
				{'O', 'O'}
		};
		Solution sl = new Solution();
		sl.solve(board);
		assertEquals('O', board[0][0]);
		assertEquals('O', board[0][1]);
		assertEquals('O', board[1][0]);
		assertEquals('O', board[1][1]);
	}
	
	@Test
	// fail to implement a core function to determine isSurrounded correctly at first
	public void testSingleSurroundedO() {
		char[][] board = new char[][] {
				{'X', 'X', 'X'},
				{'X', 'O', 'X'},
				{'X', 'X', 'X'},
		};
		Solution sl = new Solution();
		sl.solve(board);
		assertEquals('X', board[1][1]);
	}
}
