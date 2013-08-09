package com.niyue.coding.misc.matrixuniqueways;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixUniqueWaysTest {

	@Test
	public void test1x1() {
		MatrixUniqueWays matrix = new MatrixUniqueWays();
		int count = matrix.count(1);
		assertThat(count, is(1));
	}
	
	@Test
	public void test2x2() {
		MatrixUniqueWays matrix = new MatrixUniqueWays();
		int count = matrix.count(2);
		assertThat(count, is(2));
	}
	
	@Test
	public void test3x3() {
		MatrixUniqueWays matrix = new MatrixUniqueWays();
		int count = matrix.count(3);
		assertThat(count, is(12));
	}
	
	@Test
	public void test4x4() {
		MatrixUniqueWays matrix = new MatrixUniqueWays();
		int count = matrix.count(4);
		assertThat(count, is(184));
	}

}
