package com.niyue.coding.careercup.longestwordpath;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class LongestWordPathTest {

	@Test
	public void testSingleLetterDict() {
		Set<String> dict = ImmutableSet.of("a");
		LongestWordPath path = new LongestWordPath();
		List<String> max = path.longestWordPath(dict);
		assertThat(max, is(Arrays.asList("a")));
	}
	
	@Test
	public void testTwoWords() {
		Set<String> dict = ImmutableSet.of("a", "ha");
		LongestWordPath path = new LongestWordPath();
		List<String> max = path.longestWordPath(dict);
		assertThat(max, is(Arrays.asList("a", "ha")));
	}
	
	@Test
	public void testWordsInserted() {
		Set<String> dict = ImmutableSet.of("a", "ha", "he", "che", "hca");
		LongestWordPath path = new LongestWordPath();
		List<String> max = path.longestWordPath(dict);
		assertThat(max, is(Arrays.asList("a", "ha", "hca")));
	}
	
	@Test
	public void testMoreWords() {
		Set<String> dict = ImmutableSet.of("j", "ju", "jug", "juga", "jugal", "jugale");
		LongestWordPath path = new LongestWordPath();
		List<String> max = path.longestWordPath(dict);
		assertThat(max, is(Arrays.asList("j", "ju", "jug", "juga", "jugal", "jugale")));
	}

}
