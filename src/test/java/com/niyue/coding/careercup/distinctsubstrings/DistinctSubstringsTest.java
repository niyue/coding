package com.niyue.coding.careercup.distinctsubstrings;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class DistinctSubstringsTest {

	@Test
	public void testOneChar() {
		DistinctSubstrings ds = new DistinctSubstrings();
		int count = ds.count("a");
		assertThat(count, is(1));
	}
	
	@Test
	public void testTwoSameChars() {
		DistinctSubstrings ds = new DistinctSubstrings();
		int count = ds.count("aa");
		assertThat(count, is(2));
	}
	
	@Test
	public void testFourSameChars() {
		DistinctSubstrings ds = new DistinctSubstrings();
		int count = ds.count("aaaa");
		assertThat(count, is(4));
	}
	
	@Test
	public void testTwoDifferentChars() {
		DistinctSubstrings ds = new DistinctSubstrings();
		int count = ds.count("ab");
		assertThat(count, is(3));
	}
	
	@Test
	public void testFourDifferentChars() {
		DistinctSubstrings ds = new DistinctSubstrings();
		int count = ds.count("abcd");
		assertThat(count, is(10));
	}
	
	@Test
	public void testTwoRepeatingPattern() {
		DistinctSubstrings ds = new DistinctSubstrings();
		int count = ds.count("abab");
		// a, b, ab, ba, aba, bab, abab
		assertThat(count, is(7));
	}

}
