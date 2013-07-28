package com.niyue.coding.careercup.distributedmedian;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("This test case is ignored because there is a synchronization bug with the simulation code")
public class DistributedMedianTest {

	@Test
	public void testOneSlaveOneNumber() {
		System.out.println("testOneSlaveOneNumber");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1)
		));
		assertThat(median, closeTo(1, 0.001));
	}
	
	@Test
	public void testOneSlaveTwoNumbers() {
		System.out.println("testOneSlaveTwoNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1, 2)
		));
		assertThat(median, closeTo(1.5, 0.001));
	}
	
	@Test
	public void testOneSlaveThreeNumbers() {
		System.out.println("testOneSlaveThreeNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1, 2, 4)
		));
		assertThat(median, closeTo(2, 0.001));
	}
	
	@Test
	public void testOneSlaveFourNumbers() {
		System.out.println("testOneSlaveFourNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(4, 5, 2, 1)
		));
		assertThat(median, closeTo(3, 0.001));
	}
	
	@Test
	public void testTwoSlavesEachOneNumber() {
		System.out.println("testTwoSlavesEachOneNumber");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1),
			Arrays.asList(2)
		));
		assertThat(median, closeTo(1.5, 0.001));
	}
	
	@Test
	public void testTwoSlavesHavingOneNumberAndTwoNumbers() {
		System.out.println("testTwoSlavesHavingOneNumberAndTwoNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1),
			Arrays.asList(2, 3)
		));
		assertThat(median, closeTo(2, 0.001));
	}
	
	@Test
	public void testTwoSlavesHavingTwoNumbersAndTwoNumbers() {
		System.out.println("testTwoSlavesHavingTwoNumbersAndTwoNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(2, 4),
			Arrays.asList(2, 3)
		));
		assertThat(median, closeTo(2.5, 0.001));
	}
	
	@Test
	public void testTwoSlavesHavingTwoNumbersAndTwoNumbersBrokenBarrierException() {
		System.out.println("testTwoSlavesHavingTwoNumbersAndTwoNumbersBarrierException");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(2, 5),
			Arrays.asList(2, 3)
		));
		assertThat(median, closeTo(2.5, 0.001));
	}
	
	@Test
	public void testThreeSlavesHavingDuplicatedNumbers() {
		System.out.println("testThreeSlavesHavingDuplicatedNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1),
			Arrays.asList(2, 3),
			Arrays.asList(3, 2, 3)
		));
		assertThat(median, closeTo(2.5, 0.001));
	}
	
	@Test
	public void testThreeSlavesHavingLotsOfMiddleNumbers() {
		System.out.println("testThreeSlavesHavingLotsOfMiddleNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(2, 6),
			Arrays.asList(2, 2, 2),
			Arrays.asList(5, 4, 2)
		));
		assertThat(median, closeTo(2, 0.001));
	}
	
	@Test
	public void testHalfDuplicatedNumbers() {
		System.out.println("testHalfDuplicatedNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1, 1, 1),
			Arrays.asList(3, 3, 3)
		));
		assertThat(median, closeTo(2, 0.001));
	}
	
	@Test
	public void testMoreThanHalfDuplicatedNumbers() {
		System.out.println("testMoreThanHalfDuplicatedNumbers");
		DistributedMedian dm = new DistributedMedian();
		double median = dm.find(Arrays.asList(
			Arrays.asList(1, 1, 1),
			Arrays.asList(3, 3)
		));
		assertThat(median, closeTo(1, 0.001));
	}
}
