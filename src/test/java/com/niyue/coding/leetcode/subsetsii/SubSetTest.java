package com.niyue.coding.leetcode.subsetsii;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SubSetTest {

	@Test
	// empty set handling
	public void testZero() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> subSets = sl.subsetsWithDup(new int[] {0});
		assertEquals(2, subSets.size());
		assertEquals(1, subSets.get(1).size());
	}
	
	@Test
	// subSubSet should be added too, some statements are incorrectly placed (should be in the loop)
	public void testTwoDifferentNumbers() {
		Solution sl = new Solution();
		ArrayList<ArrayList<Integer>> subSets = sl.subsetsWithDup(new int[] {1, 2});
		assertEquals(4, subSets.size());
		assertEquals(0, subSets.get(0).size());
	}
}
