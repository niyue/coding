package com.niyue.coding.careercup.minwindowquery;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class OrderedMinWindowTest {

	@Test
	public void testOneElementNotExist() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(1), Arrays.asList(0));
		assertThat(min[0], is(-1));
	}
	
	@Test
	public void testOneElementExist() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(1), Arrays.asList(1));
		assertThat(min[0], is(0));
		assertThat(min[1], is(0));
	}
	
	@Test
	public void testTwoElementsExist() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(2, 1), Arrays.asList(1));
		assertThat(min[0], is(1));
		assertThat(min[1], is(1));
	}
	
	@Test
	public void testTwoElementsNotExist() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(2, 1), Arrays.asList(3));
		assertThat(min[0], is(-1));
		assertThat(min[1], is(-1));
	}
	
	@Test
	public void testTwoElementsExistTwoDifferent() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(1, 3), Arrays.asList(1, 3));
		assertThat(min[0], is(0));
		assertThat(min[1], is(1));
	}
	
	@Test
	public void testThreeElementsExistTwoDifferent() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(2, 1, 3), Arrays.asList(1, 3));
		assertThat(min[0], is(1));
		assertThat(min[1], is(2));
	}
	
	@Test
	public void testThreeElementsExistTwoNonContinuous() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(2, 1, 3), Arrays.asList(2, 3));
		assertThat(min[0], is(0));
		assertThat(min[1], is(2));
	}
	
	@Test
	public void testTwoDuplicatedElementsExistOne() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(1, 1), Arrays.asList(1));
		assertThat(min[0], is(0));
		assertThat(min[1], is(0));
	}
	
	@Test
	public void testThreeDuplicatedElementsExistTwo() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(2, 1, 1), Arrays.asList(2, 1));
		assertThat(min[0], is(0));
		assertThat(min[1], is(1));
	}
	
	@Test
	public void testOrderedAndDuplicate() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(1, 2, 1), Arrays.asList(2, 1));
		assertThat(min[0], is(1));
		assertThat(min[1], is(2));
	}
	
	@Test
	public void testComplex() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(5, 2, 0, 1, 1, 2, 2, 0, 0, 1), Arrays.asList(2, 1));
		assertThat(min[0], is(1));
		assertThat(min[1], is(3));
	}
	
	@Test
	public void testDuplicateContainsDuplidate() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(4, 2, 3, 5, 2, 1, 2, 5), Arrays.asList(2, 2));
		assertThat(min[0], is(4));
		assertThat(min[1], is(6));
	}
	
	@Test
	public void testDuplicateContainsThreeDuplidate() {
		OrderedMinWindow mw = new OrderedMinWindow();
		int[] min = mw.minWindow(Arrays.asList(2, 3, 2, 1, 2, 5, 7, 2, 1), Arrays.asList(2, 2, 2));
		assertThat(min[0], is(0));
		assertThat(min[1], is(4));
	}
}
