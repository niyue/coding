package com.niyue.coding.leetcode.spiralmatrixii;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SpiralMatrixTest {

	@Test
	public void test1() {
		SolutionTwo sl = new SolutionTwo();
		int[][] matrix = sl.generateMatrix(1);
		assertThat(matrix[0][0], is(1));
	}
	
	@Test
	public void test2() {
		SolutionTwo sl = new SolutionTwo();
		int[][] matrix = sl.generateMatrix(2);
		assertThat(matrix[0][0], is(1));
		assertThat(matrix[0][1], is(2));
		assertThat(matrix[1][1], is(3));
		assertThat(matrix[1][0], is(4));
	}

}
