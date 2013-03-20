package com.niyue.coding.leetcode.wordsearch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordSearchTest {

	@Test
	public void test1x1Exist() {
		char[][] board = new char[][]{{'a'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "a");
		assertTrue(exist);
	}
	
	@Test
	public void test1x1NonExist() {
		char[][] board = new char[][]{{'a'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "b");
		assertFalse(exist);
	}
	
	@Test
	public void test1x2Exist() {
		char[][] board = new char[][]{{'a', 'b'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "ab");
		assertTrue(exist);
	}
	
	@Test
	public void test1x2ReverseExist() {
		char[][] board = new char[][]{{'a', 'b'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "ba");
		assertTrue(exist);
	}
	
	@Test
	public void test1x2NonExist() {
		char[][] board = new char[][]{{'a', 'b'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "ac");
		assertFalse(exist);
	}
	
	@Test
	public void test2x1Exist() {
		char[][] board = new char[][]{{'a'}, {'b'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "ab");
		assertTrue(exist);
	}
	
	@Test
	public void test2x1ReverseExist() {
		char[][] board = new char[][]{{'a'}, {'b'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "ba");
		assertTrue(exist);
	}
	
	@Test
	public void test2x2Exist() {
		char[][] board = new char[][]{{'a', 'c'}, {'b', 'd'}};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "acd");
		assertTrue(exist);
		
		exist = sl.exist(board, "dba");
		assertTrue(exist);
		
		exist = sl.exist(board, "cdba");
		assertTrue(exist);
	}
	
	@Test
	public void test2x2NonExist() {
		char[][] board = new char[][]{
			{'a', 'c'}, 
			{'b', 'd'}
		};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "acb");
		assertFalse(exist);
	}
	
	@Test
	public void test3x4Exist() {
		char[][] board = new char[][]{
			 {'a', 'b', 'c', 'e'},
			 {'s', 'f', 'c', 's'},
			 {'a', 'd', 'e', 'e'}
		};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "abcced");
		assertTrue(exist);
		
		exist = sl.exist(board, "see");
		assertTrue(exist);
	}
	
	@Test
	public void test3x4NonExistVisitedChar() {
		char[][] board = new char[][]{
			 {'a', 'b', 'c', 'e'},
			 {'s', 'f', 'c', 's'},
			 {'a', 'd', 'e', 'e'}
		};
		Solution sl = new Solution();
		boolean exist = sl.exist(board, "abcb");
		assertFalse(exist);
	}
	
}
