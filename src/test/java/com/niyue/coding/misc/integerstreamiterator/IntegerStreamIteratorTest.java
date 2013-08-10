package com.niyue.coding.misc.integerstreamiterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

import com.niyue.coding.misc.integerstreamiterator.IntegerStreamIterator.IntegerCount;

public class IntegerStreamIteratorTest {
	@Test
	public void testOneIntegerCount() throws Exception {
		IntegerStreamIterator iter = new IntegerStreamIterator(Arrays.asList(
				new IntegerCount(2, 1)));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(2));
		assertThat(iter.hasNext(), is(false));
	}
	
	@Test
	public void testOneIntegerMultipleCount() throws Exception {
		IntegerStreamIterator iter = new IntegerStreamIterator(Arrays.asList(
				new IntegerCount(1, 2)));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(1));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(1));
		assertThat(iter.hasNext(), is(false));
	}
	
	@Test
	public void testMultipleIntegerCounts() throws Exception {
		IntegerStreamIterator iter = new IntegerStreamIterator(Arrays.asList(
				new IntegerCount(2, 1),
				new IntegerCount(3, 1)));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(2));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(3));
		assertThat(iter.hasNext(), is(false));
	}
	
	@Test
	public void testMultipleIntegerMultipleCounts() throws Exception {
		IntegerStreamIterator iter = new IntegerStreamIterator(Arrays.asList(
				new IntegerCount(2, 1),
				new IntegerCount(3, 2),
				new IntegerCount(1, 2)));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(2));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(3));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(3));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(1));
		assertThat(iter.hasNext(), is(true));
		assertThat(iter.next(), is(1));
		assertThat(iter.hasNext(), is(false));
	}
}
