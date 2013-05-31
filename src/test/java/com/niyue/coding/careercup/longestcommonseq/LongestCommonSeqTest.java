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
}
