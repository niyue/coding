package com.niyue.coding.careercup.longestcommonseq;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class LongestCommonSeqTest {

	@Test
	public void testZeroLength() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		int length = lcs.lcs("a", "b");
		assertThat(length, is(0));
	}
	
	@Test
	public void testOneLength() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		int length = lcs.lcs("a", "ab");
		assertThat(length, is(1));
	}
	
	@Test
	public void testTwoLength() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		int length = lcs.lcs("ab", "ab");
		assertThat(length, is(2));
	}
	
	@Test
	public void testTwoLengthForDifferentStrings() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		int length = lcs.lcs("cab", "ab");
		assertThat(length, is(2));
	}
	
	@Test
	public void testSubSequence() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		int length = lcs.lcs("cba", "ca");
		assertThat(length, is(2));
	}
	
	@Test
	public void testLongSubSequence() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		int length = lcs.lcs("thisisatest", "testing123testing");
		assertThat(length, is(7));
	}
}
