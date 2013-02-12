package com.niyue.coding.leetcode.wordladder;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class WordLadderTest {

	@Test
	public void testDictGraph() {
		Solution sl = new Solution();
		Map<String, List<String>> graph = sl.makeGraph(new HashSet<String>(Arrays.asList("a", "b")));
		assertEquals(2, graph.size());
		assertEquals(1, graph.get("a").size());
		assertEquals(1, graph.get("b").size());
	}
	
	@Test
	public void testMultiCharsDictGraph() {
		Solution sl = new Solution();
		Map<String, List<String>> graph = sl.makeGraph(new HashSet<String>(Arrays.asList("dot", "dog", "don")));
		assertEquals(3, graph.size());
		assertEquals(2, graph.get("dot").size());
		assertEquals(2, graph.get("dog").size());
		assertEquals(2, graph.get("don").size());
	}
	
	@Test
	public void testGetLength() {
		Solution sl = new Solution();
		HashSet<String> dict = new HashSet<String>(Arrays.asList("dot"));
		int length = sl.ladderLength("hot", "dog", dict);
		assertEquals(3, length);
	}
	
	@Test
	public void testGetLengthForEmptyDict() {
		Solution sl = new Solution();
		HashSet<String> dict = new HashSet<String>();
		int length = sl.ladderLength("hot", "dog", dict);
		assertEquals(0, length);
	}
	
	@Test
	public void testGetLengthTwo() {
		Solution sl = new Solution();
		HashSet<String> dict = new HashSet<String>(Arrays.asList("a", "b", "c"));
		int length = sl.ladderLength("a", "c", dict);
		assertEquals(2, length);
	}
	
	@Test
	public void testGetOverlappedStartAndEndWords() {
		Solution sl = new Solution();
		HashSet<String> dict = new HashSet<String>(Arrays.asList("most","fist","fish"));
		int length = sl.ladderLength("lost", "cost", dict);
		assertEquals(2, length);
	}
	
	@Test
	public void testGetLongLength() {
		Solution sl = new Solution();
		HashSet<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		int length = sl.ladderLength("hit", "cog", dict);
		assertEquals(5, length);
	}
}
