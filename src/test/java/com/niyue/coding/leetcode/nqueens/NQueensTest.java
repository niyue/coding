package com.niyue.coding.leetcode.nqueens;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class NQueensTest {

	@Test
	// forget to consider some base termination cases
	public void testOneQueen() {
		Solution sl = new Solution();
		ArrayList<String[]> solutions = sl.solveNQueens(1);
		assertEquals(1, solutions.size());
	}
	
	@Test
	// forget to consider all the cases for the first placement
	public void testFourQueens() {
		Solution sl = new Solution();
		ArrayList<String[]> solutions = sl.solveNQueens(4);
		assertEquals(2, solutions.size());
	}
	
	@Test
	// placement for a queen should be tested even if it can be placed in a previous column of a row
	public void testEightQueens() {
		Solution sl = new Solution();
		ArrayList<String[]> solutions = sl.solveNQueens(8);
		assertEquals(92, solutions.size());
	}
}
