package com.niyue.coding.misc.connectedcomponents;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectedComponentsTest {

	@Test
	public void test1x1() {
		int[][] matrix = new int[][] {
				{1}
		};
		ConnectedComponents cc = new ConnectedComponents();
		int count = cc.count(matrix);
		assertThat(count, is(1));
	}
	
	@Test
	public void test2x1() {
		int[][] matrix = new int[][] {
				{1, 1}
		};
		ConnectedComponents cc = new ConnectedComponents();
		int count = cc.count(matrix);
		assertThat(count, is(1));
	}
	
	@Test
	public void test2x2Diagnal() {
		int[][] matrix = new int[][] {
				{1, 0},
				{0, 1}
		};
		ConnectedComponents cc = new ConnectedComponents();
		int count = cc.count(matrix);
		assertThat(count, is(2));
	}
	
	@Test
	public void test2x2NonDiagnal() {
		int[][] matrix = new int[][] {
				{1, 1},
				{0, 1}
		};
		ConnectedComponents cc = new ConnectedComponents();
		int count = cc.count(matrix);
		assertThat(count, is(1));
	}
	
	@Test
	public void test3x3() {
		int[][] matrix = new int[][] {
				{1, 0, 1},
				{1, 0, 1},
				{0, 1, 1}
		};
		ConnectedComponents cc = new ConnectedComponents();
		int count = cc.count(matrix);
		assertThat(count, is(2));
	}

}
