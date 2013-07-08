package com.niyue.coding.careercup.mindecrementsort;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MinDecrementSortTest {

	@Test
	public void testSingleElement() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{1});
		assertThat(cost, is(0));
	}
	
	@Test
	public void testTwoSortedElements() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{1, 2});
		assertThat(cost, is(0));
	}
	
	@Test
	public void testThreeElements() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{1, 3, 2});
		assertThat(cost, is(1));
	}
	
	@Test
	public void test253() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{2, 5, 3});
		assertThat(cost, is(2));
	}
	
	@Test
	public void test2312() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{2, 3, 1, 2});
		assertThat(cost, is(2));
	}
	
	@Test
	public void test1312() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{1, 3, 1, 2});
		assertThat(cost, is(2));
	}
	
	@Test
	public void test1322() {
		MinDecrementSort sort = new MinDecrementSort();
		int cost = sort.minCost(new int[]{1, 3, 2, 2});
		assertThat(cost, is(1));
	}
}
