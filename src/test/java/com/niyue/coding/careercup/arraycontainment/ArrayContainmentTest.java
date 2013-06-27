package com.niyue.coding.careercup.arraycontainment;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
public class ArrayContainmentTest {

	@Test
	public void testSingleElement() {
		ArrayContainment ac = new ArrayContainment(new int[] {1});
		boolean contains = ac.contains(new int[] {1});
		assertThat(contains, is(true));
	}
	
	@Test
	public void testSingleElementNotContained() {
		ArrayContainment ac = new ArrayContainment(new int[] {1});
		boolean contains = ac.contains(new int[] {2});
		assertThat(contains, is(false));
	}
	
	@Test
	public void testTwoElements() {
		ArrayContainment ac = new ArrayContainment(new int[] {1, 2});
		boolean contains = ac.contains(new int[] {1, 2});
		assertThat(contains, is(true));
	}
	
	@Test
	public void testTwoElementsContainOneElement() {
		ArrayContainment ac = new ArrayContainment(new int[] {1, 2});
		boolean contains = ac.contains(new int[] {2});
		assertThat(contains, is(true));
	}
	
	@Test
	public void testTwoElementsWithDifferentOrder() {
		ArrayContainment ac = new ArrayContainment(new int[] {1, 2});
		boolean contains = ac.contains(new int[] {2, 1});
		assertThat(contains, is(false));
	}
	
	@Test
	public void testMultipleElements() {
		ArrayContainment ac = new ArrayContainment(new int[] {1, 2, 3, 4, 5});
		boolean contains = ac.contains(new int[] {2, 3});
		assertThat(contains, is(true));
	}
	
	@Test
	public void testMultipleElementsDontContain() {
		ArrayContainment ac = new ArrayContainment(new int[] {1, 2, 3, 4, 5});
		boolean contains = ac.contains(new int[] {2, 4});
		assertThat(contains, is(false));
	}
}
