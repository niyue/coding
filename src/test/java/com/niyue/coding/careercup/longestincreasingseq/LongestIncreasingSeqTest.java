package com.niyue.coding.careercup.longestincreasingseq;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LongestIncreasingSeqTest {

	@Test
	public void testSingle() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(1));
		assertThat(seq, is(Arrays.asList(1)));
	}
	
	@Test
	public void testTwoContinuous() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(1, 2));
		assertThat(seq, is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void testThreeContinuous() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(1, 2, 3));
		assertThat(seq, is(Arrays.asList(1, 2, 3)));
	}
	
	@Test
	public void testThree() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(1, 3, 2));
		assertThat(seq, is(Arrays.asList(1, 2)));
	}
	
	@Test
	public void testAllDecreasing() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(3, 2, 1, 0));
		assertThat(seq, is(Arrays.asList(0)));
	}
	
	@Test
	public void testUpDown() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(1, 2, 3, 0));
		assertThat(seq, is(Arrays.asList(1, 2, 3)));
	}
	
	@Test
	public void testUpDownUp() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(1, 2, 3, 0, 5));
		assertThat(seq, is(Arrays.asList(1, 2, 3, 5)));
	}
	
	@Test
	public void testVanDerCorputSeq() {
		LongestIncreasingSeq lis = new LongestIncreasingSeq();
		List<Integer> seq = lis.lis(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15));
		assertThat(seq, is(Arrays.asList(0, 2, 6, 9, 11, 15)));
	}
}
