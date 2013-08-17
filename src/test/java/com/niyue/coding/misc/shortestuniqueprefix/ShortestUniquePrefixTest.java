package com.niyue.coding.misc.shortestuniqueprefix;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ShortestUniquePrefixTest {

	@Test
	public void testOneString() {
		ShortestUniquePrefix sup = new ShortestUniquePrefix();
		List<String> shortestPrefixes = sup.find(Arrays.asList(
			"abc"
		));
		assertThat(shortestPrefixes, is(
			Arrays.asList("a")
		));
	}
	
	@Test
	public void testTwoStringsSharedCommonPrefix() {
		ShortestUniquePrefix sup = new ShortestUniquePrefix();
		List<String> shortestPrefixes = sup.find(Arrays.asList(
			"b",
			"c"
		));
		assertThat(shortestPrefixes, is(
			Arrays.asList("b", "c")
		));
	}
	
	@Test
	public void testThreeStringsWithoutCommonPrefix() {
		ShortestUniquePrefix sup = new ShortestUniquePrefix();
		List<String> shortestPrefixes = sup.find(Arrays.asList(
			"apple",
			"bee",
			"cat"
		));
		assertThat(shortestPrefixes, is(
			Arrays.asList("a", "b", "c")
		));
	}
	
	@Test
	public void testThreeStringsWithCommonPrefix() {
		ShortestUniquePrefix sup = new ShortestUniquePrefix();
		List<String> shortestPrefixes = sup.find(Arrays.asList(
			"apple",
			"bee",
			"cat",
			"cedar"
		));
		assertThat(shortestPrefixes, is(
			Arrays.asList("a", "b", "ca", "ce")
		));
	}

}
