package com.niyue.coding.leetcode.rotateimage;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RoateImageTest {

	@Test
	public void test1x1() {
		Solution sl = new Solution();
		int[][] matrix = new int[][]{{1}};
		sl.rotate(matrix);
		assertThat(matrix, equalTo(new int[][]{{1}}));
	}
	
	@Test
	public void test2x2() {
		Solution sl = new Solution();
		int[][] matrix = new int[][]{{1, 2}, {3, 4}};
		sl.rotate(matrix);
		assertThat(matrix, equalTo(new int[][]{{3, 1}, {4, 2}}));
	}
}
