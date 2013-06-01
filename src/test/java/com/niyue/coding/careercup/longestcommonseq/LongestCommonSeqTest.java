package com.niyue.coding.careercup.longestcommonseq;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class LongestCommonSeqTest {

	@Test
	public void testZeroLength() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		String seq = lcs.lcs("a", "b");
		assertThat(seq, is(""));
	}
	
	@Test
	public void testOneLength() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		String seq = lcs.lcs("a", "ab");
		assertThat(seq, is("a"));
	}
	
	@Test
	public void testTwoLength() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		String seq = lcs.lcs("ab", "ab");
		assertThat(seq, is("ab"));
	}
	
	@Test
	public void testTwoLengthForDifferentStrings() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		String seq = lcs.lcs("cab", "ab");
		assertThat(seq, is("ab"));
	}
	
	@Test
	public void testSubSequence() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		String seq = lcs.lcs("cba", "ca");
		assertThat(seq, is("ca"));
	}
	
	@Test
	public void testLongSubSequence() {
		LongestCommonSeq lcs = new LongestCommonSeq();
		String seq = lcs.lcs("thisisatest", "testing123testing");
		assertThat(seq, is("tsitest"));
	}
}
