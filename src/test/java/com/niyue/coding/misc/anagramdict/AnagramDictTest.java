package com.niyue.coding.misc.anagramdict;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class AnagramDictTest {

	@Test
	public void testOneCharWordWithOneWordDict() {
		AnagramDict dict = new AnagramDict();
		List<String> words = dict.restore("a", ImmutableSet.of("a"));
		assertThat(words, is(Arrays.asList("a")));
	}
	
	@Test
	public void testTwoCharsWordWithOneCharSkipped() {
		AnagramDict dict = new AnagramDict();
		List<String> words = dict.restore("ba", ImmutableSet.of("a"));
		assertThat(words, is(Arrays.asList("a")));
	}
	
	@Test
	public void testTwoMultipleCharsWordWithOneCharSkipped() {
		AnagramDict dict = new AnagramDict();
		List<String> words = dict.restore("bih", ImmutableSet.of("hi"));
		assertThat(words, is(Arrays.asList("hi")));
	}
	
	@Test
	public void testSkippedFirst() {
		AnagramDict dict = new AnagramDict();
		List<String> words = dict.restore("abih", ImmutableSet.of("bhi", "ab"));
		assertThat(words, is(Arrays.asList("bhi")));
	}
	
	@Test
	public void testMinSkipped() {
		AnagramDict dict = new AnagramDict();
		List<String> words = dict.restore("abih", ImmutableSet.of("bhi", "hi", "ab"));
		assertThat(words, is(Arrays.asList("ab", "hi")));
	}
	
	@Test
	public void testOneCharInTheMiddleSkipped() {
		AnagramDict dict = new AnagramDict();
		List<String> words = dict.restore("iwndowdcta", ImmutableSet.of("window", "cat"));
		assertThat(words, is(Arrays.asList("window", "cat")));
	}
}
