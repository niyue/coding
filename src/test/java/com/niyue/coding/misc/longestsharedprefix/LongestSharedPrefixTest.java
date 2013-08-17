package com.niyue.coding.misc.longestsharedprefix;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class LongestSharedPrefixTest {

	@Test
	public void testOneString() {
		LongestSharedPrefix lsp = new LongestSharedPrefix();
		String prefix = lsp.find(Arrays.asList(
				"abc"));
		assertThat(prefix, is(""));
	}
	
	@Test
	public void testTwoStrings() {
		LongestSharedPrefix lsp = new LongestSharedPrefix();
		String prefix = lsp.find(Arrays.asList(
				"abc",
				"abdd"));
		assertThat(prefix, is("ab"));
	}
	
	@Test
	public void testThreeStrings() {
		LongestSharedPrefix lsp = new LongestSharedPrefix();
		String prefix = lsp.find(Arrays.asList(
				"abc",
				"abdd",
				"a"));
		assertThat(prefix, is("ab"));
	}
	
	@Test
	public void testTwoGroupsPrefixes() {
		LongestSharedPrefix lsp = new LongestSharedPrefix();
		String prefix = lsp.find(Arrays.asList(
				"abc",
				"abdd",
				"bdddd",
				"bdd"));
		assertThat(prefix, is("bdd"));
	}
	
	@Test
	public void testFiveStrings() {
		LongestSharedPrefix lsp = new LongestSharedPrefix();
		String prefix = lsp.find(Arrays.asList(
				"abc",
				"abdd",
				"adddd",
				"add",
				"addd"));
		assertThat(prefix, is("addd"));
	}

}
