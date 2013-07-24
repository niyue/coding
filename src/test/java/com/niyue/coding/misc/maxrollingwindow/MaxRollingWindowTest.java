package com.niyue.coding.misc.maxrollingwindow;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MaxRollingWindowTest {

	@Test
	public void testOneElement() {
		MaxRollingWindow mrw = new MaxRollingWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(2), 1);
		assertThat(maxes, is(Arrays.asList(2)));
	}
	
	@Test
	public void testTwoElementsSizeOneWindow() {
		MaxRollingWindow mrw = new MaxRollingWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(3, 2), 1);
		assertThat(maxes, is(Arrays.asList(3, 2)));
	}
	
	@Test
	public void testThreeElementsSizeTwoWindow() {
		MaxRollingWindow mrw = new MaxRollingWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(3, 2, 4), 2);
		assertThat(maxes, is(Arrays.asList(3, 4)));
	}
	
	@Test
	public void testFourElementsSizeTwoWindowWithDuplicates() {
		MaxRollingWindow mrw = new MaxRollingWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(3, 2, 4, 2), 2);
		assertThat(maxes, is(Arrays.asList(3, 4, 4)));
	}
	
	@Test
	public void testFiveElementsSizeThreeWindow() {
		MaxRollingWindow mrw = new MaxRollingWindow();
		List<Integer> maxes = mrw.search(Arrays.asList(1, 2, 3, 4, 2), 3);
		assertThat(maxes, is(Arrays.asList(3, 4, 4)));
	}
}
