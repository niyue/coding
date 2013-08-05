package com.niyue.coding.misc.balancedpartition;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class BalancedPartitionTest {

	@Test
	public void testOneElement() {
		BalancedPartition bp = new BalancedPartition();
		int closestSum = bp.partition(Arrays.asList(1));
		assertThat(closestSum, is(0));
	}
	
	@Test
	public void testTwoElements() {
		BalancedPartition bp = new BalancedPartition();
		int closestSum = bp.partition(Arrays.asList(1, 2));
		assertThat(closestSum, is(1));
	}
	
	@Test
	public void testThreeElements() {
		BalancedPartition bp = new BalancedPartition();
		int closestSum = bp.partition(Arrays.asList(1, 3, 2));
		assertThat(closestSum, is(3));
	}
	
	@Test
	public void testFourElements() {
		BalancedPartition bp = new BalancedPartition();
		int closestSum = bp.partition(Arrays.asList(1, 4, 3, 2));
		assertThat(closestSum, is(5));
	}
	
	@Test
	public void testFiveElements() {
		BalancedPartition bp = new BalancedPartition();
		int closestSum = bp.partition(Arrays.asList(1, 4, 1, 3, 2));
		assertThat(closestSum, is(5));
	}

}
