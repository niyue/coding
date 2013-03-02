package com.niyue.coding.leetcode.sortedarraytobst;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.niyue.coding.leetcode.common.TreeNode;

public class SortedArrayToBstTest {

	@Test
	public void test0() {
		Solution sl = new Solution();
		TreeNode node = sl.sortedArrayToBST(new int[] {0});
		assertNotNull(node);
	}
}
