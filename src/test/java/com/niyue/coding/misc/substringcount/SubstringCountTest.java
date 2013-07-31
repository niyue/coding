package com.niyue.coding.misc.substringcount;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringCountTest {

	@Test
	public void testSingleChar() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("a", "a");
		assertThat(count, is(1));
	}
	
	@Test
	public void testSingleCharNotMatched() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("a", "b");
		assertThat(count, is(0));
	}
	
	@Test
	public void testTwoCharsTextOneCharPattern() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("ab", "a");
		assertThat(count, is(1));
	}
	
	@Test
	public void testTwoCharsTextTwoCharsPattern() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("ab", "ab");
		assertThat(count, is(1));
	}
	
	@Test
	public void testMultipleAppearedPatternInText() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("abab", "ab");
		assertThat(count, is(2));
	}
	
	@Test
	public void testOverlappedPatternInText() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("ababa", "aba");
		assertThat(count, is(2));
	}
	
	@Test
	public void testMultipleCharsPatternNotInText() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("ababa", "abc");
		assertThat(count, is(0));
	}
	
	@Test
	public void testTrailingPatternInText() {
		SubstringCount sc = new SubstringCount();
		int count = sc.count("ababa", "ba");
		assertThat(count, is(2));
	}
}
