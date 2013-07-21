package com.niyue.coding.misc.suffixtree;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SuffixTreeTest {

	@Test
	public void testTwoChars() {
		String s = "ab";
		SuffixTree st = new SuffixTree(s);
		List<Integer> indexes = st.getIndexes("a");
		assertThat(indexes, is(Arrays.asList(0)));
		
		indexes = st.getIndexes("b");
		assertThat(indexes, is(Arrays.asList(1)));
	}
	
	@Test
	public void testDulicatedChars() {
		String s = "abacb";
		SuffixTree st = new SuffixTree(s);
		List<Integer> indexes = st.getIndexes("a");
		assertThat(indexes, is(Arrays.asList(0, 2)));
		
		indexes = st.getIndexes("b");
		assertThat(indexes, is(Arrays.asList(1, 4)));
	}
	
	@Test
	public void testMultipleChars() {
		String s = "abacba";
		SuffixTree st = new SuffixTree(s);
		List<Integer> indexes = st.getIndexes("ab");
		assertThat(indexes, is(Arrays.asList(0)));
		
		indexes = st.getIndexes("ba");
		assertThat(indexes, is(Arrays.asList(1, 4)));
	}
}
