package com.niyue.coding.misc.subanagram;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubAnagramTest {

	@Test
	public void testTwoCharsAndOneChar() {
		SubAnagram anagram = new SubAnagram();
		List<String> anagrams = anagram.find("ab", "a");
		assertThat(anagrams, is(Arrays.asList("a")));
	}
	
	@Test
	public void testTwoCharsAndTwoCharsWithDifferentOrder() {
		SubAnagram anagram = new SubAnagram();
		List<String> anagrams = anagram.find("ab", "ba");
		assertThat(anagrams, is(Arrays.asList("ab")));
	}
	
	@Test
	public void testThreeCharsAndTwoCharsWithDifferentOrder() {
		SubAnagram anagram = new SubAnagram();
		List<String> anagrams = anagram.find("acb", "bc");
		assertThat(anagrams, is(Arrays.asList("cb")));
	}
	
	@Test
	public void testMultipleAnagrams() {
		SubAnagram anagram = new SubAnagram();
		List<String> anagrams = anagram.find("bcacb", "bc");
		assertThat(anagrams, is(Arrays.asList("bc", "cb")));
	}
	
	@Test
	public void testOverlappedAnagrams() {
		SubAnagram anagram = new SubAnagram();
		List<String> anagrams = anagram.find("bcbcb", "bbc");
		assertThat(anagrams, is(Arrays.asList("bcb", "bcb")));
	}

}
