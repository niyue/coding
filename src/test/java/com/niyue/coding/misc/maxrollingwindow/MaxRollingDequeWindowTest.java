package com.niyue.coding.misc.maxrollingwindow;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MaxRollingDequeWindowTest {

	@Test
	public void testOneElement() {
		MaxRollingDequeWindow mrw = new MaxRollingDequeWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(2), 1);
		assertThat(maxes, is(Arrays.asList(2)));
	}
	
	@Test
	public void testTwoElementsSizeOneWindow() {
		MaxRollingDequeWindow mrw = new MaxRollingDequeWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(3, 2), 1);
		assertThat(maxes, is(Arrays.asList(3, 2)));
	}
	
	@Test
	public void testThreeElementsSizeTwoWindow() {
		MaxRollingDequeWindow mrw = new MaxRollingDequeWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(3, 2, 4), 2);
		assertThat(maxes, is(Arrays.asList(3, 4)));
	}
	
	@Test
	public void testFourElementsSizeTwoWindowWithDuplicates() {
		MaxRollingDequeWindow mrw = new MaxRollingDequeWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(3, 2, 4, 2), 2);
		assertThat(maxes, is(Arrays.asList(3, 4, 4)));
	}
	
	@Test
	public void testFiveElementsSizeThreeWindow() {
		MaxRollingDequeWindow mrw = new MaxRollingDequeWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(1, 2, 3, 4, 2), 3);
		assertThat(maxes, is(Arrays.asList(3, 4, 4)));
	}
}
