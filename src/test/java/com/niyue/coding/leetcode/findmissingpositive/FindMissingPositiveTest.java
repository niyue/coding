package com.niyue.coding.leetcode.findmissingpositive;

import static org.junit.Assert.*;

import org.junit.Test;

// different errors I ran into when fixing the findMissingNumber function
public class FindMissingPositiveTest {

	@Test
	public void testEmpty() {
		Solution sl = new Solution();
		int missingNumber = sl.firstMissingPositive(new int[] {});
		assertEquals(1, missingNumber);
	}
	
	@Test
	public void test1() {
		Solution sl = new Solution();
		int missingNumber = sl.firstMissingPositive(new int[] {1});
		assertEquals(2, missingNumber);
	}
	
	@Test
	public void test11() {
		Solution sl = new Solution();
		int missingNumber = sl.firstMissingPositive(new int[] {1, 1});
		assertEquals(2, missingNumber);
	}
	
	@Test
	public void test21() {
		Solution sl = new Solution();
		int missingNumber = sl.firstMissingPositive(new int[] {2, 1});
		assertEquals(3, missingNumber);
	}
	
	@Test
	public void test012() {
		Solution sl = new Solution();
		int missingNumber = sl.firstMissingPositive(new int[] {0, 1, 2});
		assertEquals(3, missingNumber);
	}
}
