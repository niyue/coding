package com.niyue.coding.leetcode.spiralmatrix;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SpiralMatrixTwoTest {

	@Test
	public void test1x1() {
		SolutionTwo sl = new SolutionTwo();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{1}});
		assertThat(spiral, equalTo(Arrays.asList(1)));
	}
	
	@Test
	public void test2x1() {
		SolutionTwo sl = new SolutionTwo();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{2, 3}});
		assertThat(spiral, equalTo(Arrays.asList(2, 3)));
	}
	
	@Test
	public void test2x2() {
		SolutionTwo sl = new SolutionTwo();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{1, 2}, {3, 4}});
		assertThat(spiral, equalTo(Arrays.asList(1, 2, 4, 3)));
	}
	
	@Test
	public void test2x3() {
		SolutionTwo sl = new SolutionTwo();
		List<Integer> spiral = sl.spiralOrder(new int[][]{{2, 5}, {8, 4}, {0, -1}});
		assertThat(spiral, equalTo(Arrays.asList(2, 5, 4, -1, 0, 8)));
	}
}
