package com.niyue.coding.misc.longestcommonprefix;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

	@Test
	public void testSingleString() {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String prefix = lcp.find(new String[] {"abc"}, 0.9);
		assertThat(prefix, is("abc"));
	}
	
	@Test
	public void testTwoStrings() {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String prefix = lcp.find(new String[] {"abc", "ab"}, 0.9);
		assertThat(prefix, is("ab"));
	}
	
	@Test
	public void testTwoStringsWithHalfPercentage() {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String prefix = lcp.find(new String[] {"abc", "ab"}, 0.5);
		assertThat(prefix, is("abc"));
	}
	
	@Test
	public void testThreeStrings() {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String prefix = lcp.find(new String[] {"abc", "abcce", "abcc"}, 0.6);
		assertThat(prefix, is("abcc"));
	}
	
	@Test
	public void testThreeStringsWithHighPercentage() {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String prefix = lcp.find(new String[] {"abc", "abcce", "abcc"}, 0.68);
		assertThat(prefix, is("abc"));
	}

}
