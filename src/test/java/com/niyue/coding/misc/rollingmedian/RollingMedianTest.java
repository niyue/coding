package com.niyue.coding.misc.rollingmedian;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class RollingMedianTest {
	@Test
	public void testOneNumberWithSizeOneWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(2), 1);
		assertThat(medians.get(0), closeTo(2, 0.01));
	}
	
	@Test
	public void testThreeNumbersWithSizeOneWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(2, 3, 4), 1);
		assertThat(medians.get(0), closeTo(2, 0.01));
		assertThat(medians.get(1), closeTo(3, 0.01));
		assertThat(medians.get(2), closeTo(4, 0.01));
	}
	
	@Test
	public void testThreeNumbersWithSizeTwoWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(2, 3, 4), 2);
		assertThat(medians.size(), is(2));
		assertThat(medians.get(0), closeTo(2.5, 0.01));
		assertThat(medians.get(1), closeTo(3.5, 0.01));
	}
	
	@Test
	public void testSixNumbersWithSizeThreeWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(3, 2, 5, 2, 1, 6), 3);
		assertThat(medians.size(), is(4));
		assertThat(medians.get(0), closeTo(3, 0.01));
		assertThat(medians.get(1), closeTo(2, 0.01));
		assertThat(medians.get(2), closeTo(2, 0.01));
		assertThat(medians.get(3), closeTo(2, 0.01));
	}
	
	@Test
	public void testIncreasingSequenceFourWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(1, 2, 3, 4, 5, 6), 4);
		assertThat(medians.size(), is(3));
		assertThat(medians.get(0), closeTo(2.5, 0.01));
		assertThat(medians.get(1), closeTo(3.5, 0.01));
		assertThat(medians.get(2), closeTo(4.5, 0.01));
	}
	
	@Test
	public void testDecreasingSequenceFourWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(6, 5, 4, 3, 2, 1), 4);
		assertThat(medians.size(), is(3));
		assertThat(medians.get(0), closeTo(4.5, 0.01));
		assertThat(medians.get(1), closeTo(3.5, 0.01));
		assertThat(medians.get(2), closeTo(2.5, 0.01));
	}
	
	@Test
	public void testDecreasingSequenceThreeWindow() throws Exception {
		RollingMedian rm = new RollingMedian();
		List<Double> medians = rm.find(Arrays.asList(6, 5, 4, 3, 2, 1), 3);
		assertThat(medians.size(), is(4));
		assertThat(medians.get(0), closeTo(5, 0.01));
		assertThat(medians.get(1), closeTo(4, 0.01));
		assertThat(medians.get(2), closeTo(3, 0.01));
		assertThat(medians.get(3), closeTo(2, 0.01));
	}
}
