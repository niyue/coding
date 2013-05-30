package com.niyue.coding.careercup.longestincreasingseq;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LongestIncreasingSeqTest {

	@Test
	public void testSingle() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(1));
		assertEquals(1, length);
	}
	
	@Test
	public void testTwoContinuous() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(1, 2));
		assertEquals(2, length);
	}
	
	@Test
	public void testThreeContinuous() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(1, 2, 3));
		assertEquals(3, length);
	}
	
	@Test
	public void testThree() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(1, 3, 2));
		assertEquals(2, length);
	}
	
	@Test
	public void testAllDecreasing() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(3, 2, 1, 0));
		assertEquals(1, length);
	}
	
	@Test
	public void testUpDown() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(1, 2, 3, 0));
		assertEquals(3, length);
	}
	
	@Test
	public void testUpDownUp() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		int length = lis.lis(Arrays.asList(1, 2, 3, 0, 5));
		assertEquals(4, length);
	}
}
