package com.niyue.coding.misc.biggestcommonwordspair;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BiggestCommonWordsPairTest {

	@Test
	public void testSample() {
		List<String> sentences = Arrays.asList(
			"This is a good day",
			"This is a bad day",
			"That was good day"
		);
		BiggestCommonWordsPair bcp = new BiggestCommonWordsPair();
		int[] pair = bcp.find(sentences);
		assertThat(pair, is(new int[]{0, 1}));
	}

}
