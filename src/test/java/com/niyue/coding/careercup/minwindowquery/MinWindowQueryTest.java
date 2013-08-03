package com.niyue.coding.careercup.minwindowquery;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class MinWindowQueryTest {
	@Test
	public void testNonExistingMinWindowQuery() throws Exception {
		MinWindowQuery query = new MinWindowQuery();
		String window = query.minWindow("hello", ImmutableSet.of("world"));
		assertThat(window, is(""));
	}
	
	@Test
	public void testSingleWordMinWindowQuery() throws Exception {
		MinWindowQuery query = new MinWindowQuery();
		String window = query.minWindow("hello world", ImmutableSet.of("world"));
		assertThat(window, is("world"));
	}
	
	@Test
	public void testTwoWordsMinWindowQuery() throws Exception {
		MinWindowQuery query = new MinWindowQuery();
		String window = query.minWindow("hello world from java", ImmutableSet.of("world", "hello"));
		assertThat(window, is("hello world"));
	}
	
	@Test
	public void testDuplicatedWordsMinWindowQuery() throws Exception {
		MinWindowQuery query = new MinWindowQuery();
		String window = query.minWindow("hello your world from my hello java", ImmutableSet.of("world", "hello"));
		assertThat(window, is("hello your world"));
	}
	
	@Test
	public void testComplexy() throws Exception {
		MinWindowQuery query = new MinWindowQuery();
		String window = query.minWindow("A C D D A B D C B C C D C A B D B", ImmutableSet.of("A", "C", "B"));
		assertThat(window, is("A B D C"));
	}
}
