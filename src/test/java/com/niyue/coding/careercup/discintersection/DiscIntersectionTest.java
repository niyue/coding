package com.niyue.coding.careercup.discintersection;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscIntersectionTest {
	@Test
	public void testOneDisc() {
		DiscIntersection disc = new DiscIntersection();
		int total = disc.count(new int[] {1});
		assertEquals(0, total);
	}
	
	@Test
	public void testTwoDiscs() {
		DiscIntersection disc = new DiscIntersection();
		int total = disc.count(new int[] {2, 1});
		assertEquals(1, total);
	}
	
	@Test
	public void testThreeDiscs() {
		DiscIntersection disc = new DiscIntersection();
		int total = disc.count(new int[] {2, 1, 2});
		assertEquals(3, total);
	}
	
	@Test
	public void testSample() {
		DiscIntersection disc = new DiscIntersection();
		int total = disc.count(new int[] {1, 5, 2, 1, 4, 0});
		assertEquals(11, total);
	}
}
