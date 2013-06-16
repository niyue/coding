package com.niyue.coding.careercup.twowordsindict;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class TwoWordsInDictTest {

	@Test
	public void testTwoWords() {
		TwoWordsInDict twid = new TwoWordsInDict();
		List<String> words = twid.split("newspaper", new HashSet<String>
			(Arrays.asList("news", "paper", "new", "pa")));
		assertThat(words, is(Arrays.asList("news", "paper")));
	}
	
	@Test
	public void testNoSolution() {
		TwoWordsInDict twid = new TwoWordsInDict();
		List<String> words = twid.split("newspaper", new HashSet<String>
			(Arrays.asList("paper", "new", "pa")));
		assertThat(words, nullValue());
	}

}
