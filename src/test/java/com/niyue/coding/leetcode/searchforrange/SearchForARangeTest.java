package com.niyue.coding.leetcode.searchforrange;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SearchForARangeTest {

	@Test
	public void testSingleFoundElement() {
		Solution sl = new Solution();
		int[] range = sl.searchRange(new int[] {1}, 1);
		assertThat(range[0], is(0));
		assertThat(range[1], is(0));
	}
	
	@Test
	public void testSingleNotFoundElement() {
		Solution sl = new Solution();
		int[] range = sl.searchRange(new int[] {1}, 0);
		assertThat(range[0], is(-1));
		assertThat(range[1], is(-1));
	}
	
	@Test
	public void testTwoDifferntElementsFound() {
		Solution sl = new Solution();
		int[] range = sl.searchRange(new int[] {0, 1}, 1);
		assertThat(range[0], is(1));
		assertThat(range[1], is(1));
	}
	
	@Test
	public void testTwoDifferntElementsNotFound() {
		Solution sl = new Solution();
		int[] range = sl.searchRange(new int[] {0, 1}, 2);
		assertThat(range[0], is(-1));
		assertThat(range[1], is(-1));
	}
	
	@Test
	public void testTwoSameElementsFound() {
		Solution sl = new Solution();
		int[] range = sl.searchRange(new int[] {1, 1}, 1);
		assertThat(range[0], is(0));
		assertThat(range[1], is(1));
	}

}
