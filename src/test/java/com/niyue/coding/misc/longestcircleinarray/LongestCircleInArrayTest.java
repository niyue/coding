package com.niyue.coding.misc.longestcircleinarray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCircleInArrayTest {

	@Test
	public void testNoCircle() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {null});
		assertThat(longestCircle, is(0));
	}
	
	@Test
	public void testSelfCircle() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {0});
		assertThat(longestCircle, is(1));
	}
	
	@Test
	public void testTwoLengthCircle() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {1, 0});
		assertThat(longestCircle, is(2));
	}
	
	@Test
	public void testNoCircleTwoElements() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {1, null});
		assertThat(longestCircle, is(0));
	}
	
	@Test
	public void testTwoLengthCircleInThree() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {2, 2, 1});
		assertThat(longestCircle, is(2));
	}
	
	@Test
	public void testCircleWithBranchingInTheEnd() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {1, 0, 1});
		assertThat(longestCircle, is(2));
	}
	
	@Test
	public void testTwoCirclesWithDifferentLength() {
		LongestCircleInArray lca = new LongestCircleInArray();
		int longestCircle = lca.longestCircle(new Integer[] {1, 0, 1, 4, 5, 3});
		assertThat(longestCircle, is(3));
	}
}
