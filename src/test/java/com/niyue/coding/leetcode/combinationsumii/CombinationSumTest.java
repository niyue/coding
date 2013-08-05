package com.niyue.coding.leetcode.combinationsumii;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class CombinationSumTest {

	@Test
	public void test21() {
		Solution2 sl = new Solution2();
		ArrayList<ArrayList<Integer>> result = sl.combinationSum2(new int[] {2}, 1);
		assertThat(result, is(Collections.<ArrayList<Integer>>emptyList()));
	}
	
	@Test
	public void test121() {
		Solution2 sl = new Solution2();
		ArrayList<ArrayList<Integer>> result = sl.combinationSum2(new int[] {1, 2}, 1);
		assertThat(result.size(), is(1));
	}
	
	@Test
	public void test122() {
		Solution2 sl = new Solution2();
		ArrayList<ArrayList<Integer>> result = sl.combinationSum2(new int[] {1, 2}, 2);
		assertThat(result.size(), is(1));
	}

}
