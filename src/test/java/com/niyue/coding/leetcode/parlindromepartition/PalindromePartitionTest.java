package com.niyue.coding.leetcode.parlindromepartition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.niyue.coding.leetcode.palindromepartition.Solution;

public class PalindromePartitionTest {

	@Test
	// fail to implement the sub partition processing correctly 
	public void testCdd() {
		Solution sl = new Solution();
		ArrayList<ArrayList<String>> partitions = sl.partition("cdd");
		assertEquals(2, partitions.size());
		assertEquals(3, partitions.get(0).size());
		assertEquals(2, partitions.get(1).size());
	}
}
