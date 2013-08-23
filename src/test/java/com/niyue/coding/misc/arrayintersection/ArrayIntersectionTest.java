package com.niyue.coding.misc.arrayintersection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayIntersectionTest {
	@Test
	public void testNoIntersection() throws Exception {
		ArrayIntersection ai = new ArrayIntersection();
		List<Integer> intersection = ai.intersect(
				new int[] {1}, 
				new int[] {2});
		assertThat(intersection.isEmpty(), is(true));
	}
	
	@Test
	public void testOneElementIntersection() throws Exception {
		ArrayIntersection ai = new ArrayIntersection();
		List<Integer> intersection = ai.intersect(
				new int[] {1}, 
				new int[] {1});
		assertThat(intersection, is(Arrays.asList(1)));
	}
	
	@Test
	public void testMultipleElementsIntersection() throws Exception {
		ArrayIntersection ai = new ArrayIntersection();
		List<Integer> intersection = ai.intersect(
				new int[] {1, 1, 2, 3}, 
				new int[] {1, 1, 3, 4});
		assertThat(intersection, is(Arrays.asList(1, 1, 3)));
	}
	
	@Test
	public void testBinaryIntersection() throws Exception {
		ArrayIntersection ai = new ArrayIntersection();
		List<Integer> intersection = ai.intersect(
				new int[] {1, 2, 3}, 
				new int[] {2, 3, 4});
		assertThat(intersection, is(Arrays.asList(2, 3)));
	}
}
