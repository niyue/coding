package com.niyue.coding.careercup.woodcutting;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class WoodCuttingTest {

	@Test
	public void testOneMark() {
		WoodCutting wc = new WoodCutting();
		int minCost = wc.cost(Arrays.asList(1), 3);
		assertThat(minCost, is(3));
	}
	
	@Test
	public void testTwoEqualMarks() {
		WoodCutting wc = new WoodCutting();
		int minCost = wc.cost(Arrays.asList(1, 2), 3);
		assertThat(minCost, is(5));
	}
	
	@Test
	public void testTwoUnequalMarks() {
		WoodCutting wc = new WoodCutting();
		int minCost = wc.cost(Arrays.asList(1, 2), 4);
		assertThat(minCost, is(6));
	}
	
	@Test
	public void testThreeMarks() {
		WoodCutting wc = new WoodCutting();
		int minCost = wc.cost(Arrays.asList(4, 5, 7), 10);
		assertThat(minCost, is(19));
	}
	
	@Test
	public void testIncreasingLengthMarks() {
		WoodCutting wc = new WoodCutting();
		int minCost = wc.cost(Arrays.asList(1, 3, 6, 10, 15), 21);
		// (((1 2) 3) 4) (5 6))
		assertThat(minCost, is(21 + 11 + 19));
	}
}
