package com.niyue.coding.careercup.integerpartition;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class IntegerPartitionTest {

	@Test
	public void testPartition() {
		IntegerPartition ip = new IntegerPartition();
		List<List<Integer>> partitions = ip.partition(1, 1);
		assertThat(partitions.size(), is(1));
	}
	
	@Test
	public void test52() {
		IntegerPartition ip = new IntegerPartition();
		List<List<Integer>> partitions = ip.partition(5, 2);
		assertThat(partitions.size(), is(6));
	}
	
	@Test
	public void test53() {
		IntegerPartition ip = new IntegerPartition();
		List<List<Integer>> partitions = ip.partition(5, 3);
		assertThat(partitions.size(), is(21));
	}
}
