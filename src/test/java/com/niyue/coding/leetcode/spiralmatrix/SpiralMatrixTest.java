package com.niyue.coding.leetcode.spiralmatrix;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SpiralMatrixTest {

	@Test
	// cannot handle the odd length case
	public void test1x1() {
		Solution sl = new Solution();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{1}});
		assertThat(spiral, equalTo(Arrays.asList(1)));
	}
	
	@Test
	// mixed up x axis with y axis incorrectly
	public void test2x1() {
		Solution sl = new Solution();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{2, 3}});
		assertThat(spiral, equalTo(Arrays.asList(2, 3)));
	}
	
	@Test
	// mixed up x axis with y axis incorrectly
	public void test2x2() {
		Solution sl = new Solution();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{1, 2}, {3, 4}});
		assertThat(spiral, equalTo(Arrays.asList(1, 2, 4, 3)));
	}
}
