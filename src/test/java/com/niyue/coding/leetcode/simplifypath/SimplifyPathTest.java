package com.niyue.coding.leetcode.simplifypath;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SimplifyPathTest {
	@Test
	public void testEmptyPath() throws Exception {
		SolutionTwo sl = new SolutionTwo();
		String path = sl.simplifyPath("");
		assertThat(path, is("/"));
	}
	
	@Test
	public void testRootOnly() throws Exception {
		SolutionTwo sl = new SolutionTwo();
		String path = sl.simplifyPath("/");
		assertThat(path, is("/"));
	}
	
	@Test
	public void testDotFile() throws Exception {
		SolutionTwo sl = new SolutionTwo();
		String path = sl.simplifyPath("/.hidden");
		assertThat(path, is("/.hidden"));
	}
	
	@Test
	public void testTwoSegments() throws Exception {
		SolutionTwo sl = new SolutionTwo();
		String path = sl.simplifyPath("/home/foo");
		assertThat(path, is("/home/foo"));
	}
}
