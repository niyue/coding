package com.niyue.coding.leetcode.candy;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

	@Test
	public void testEmptyRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {});
		assertThat(total, is(0));
	}
	
	@Test
	public void testSingleRating() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2});
		assertThat(total, is(1));
	}
	
	@Test
	public void testTwoAscendingRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {1, 2});
		assertThat(total, is(3));
	}
	
	@Test
	public void testTwoDescendingRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2, 1});
		assertThat(total, is(3));
	}
	
	@Test
	public void testTwoEqualRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2, 2});
		assertThat(total, is(2));
	}
	
	@Test
	public void testThreeAscendingRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {1, 2, 3});
		assertThat(total, is(6));
	}
	
	@Test
	public void testThreeDescendingRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {3, 2, 1});
		assertThat(total, is(6));
	}
	
	@Test
	public void testThreeEqualRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2, 2, 2});
		assertThat(total, is(3));
	}
	
	@Test
	public void testTwoEqualRatingsThenDescending() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2, 2, 1});
		assertThat(total, is(4));
	}
	
	@Test
	public void testThreeAscendingThenDescendingRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {1, 2, 1});
		assertThat(total, is(4));
	}
	
	@Test
	public void testZigZagRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2, 3, 4, 1});
		assertThat(total, is(7));
	}
	
	@Test
	public void testLongZigZagRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {1, 2, 3, 4, 2, 1});
		assertThat(total, is(13));
	}
	
	@Test
	public void testLongRatings() {
		Solution sl = new Solution();
		int total = sl.candy(new int[] {2, 1, 1, 1, 3, 2, 1, 1, 1, 2});
		assertThat(total, is(15));
	}

}
