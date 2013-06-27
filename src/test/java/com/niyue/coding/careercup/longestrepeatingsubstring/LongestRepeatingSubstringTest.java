package com.niyue.coding.careercup.longestrepeatingsubstring;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LongestRepeatingSubstringTest {

	@Test
	public void testSample() {
		LongestRepeatingSubstring lrs = new LongestRepeatingSubstring();
		String substring = lrs.search("ababab");
		assertThat(substring, is("abab"));
	}
	
	@Test
	public void testEntireStringRepeating() {
		LongestRepeatingSubstring lrs = new LongestRepeatingSubstring();
		String substring = lrs.search("abab");
		assertThat(substring, is("abab"));
	}
	
	@Test
	public void testSingleCharRepeating() {
		LongestRepeatingSubstring lrs = new LongestRepeatingSubstring();
		String substring = lrs.search("aa");
		assertThat(substring, is("aa"));
	}
	
	
}
