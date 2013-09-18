package com.niyue.coding.leetcode.uniquebstii;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import com.niyue.coding.careercup.commonancestor.TreeNode;

public class SolutionTwoTest {

	@Test
	public void test3() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<TreeNode> trees = sl.generateTrees(3);
		assertThat(trees.size(), is(5));
		TreeNode root = trees.get(0);
		assertThat(root.id, is(1));
		assertThat(root.left, nullValue());
		assertThat(root.right.id, is(2));
	}

}
