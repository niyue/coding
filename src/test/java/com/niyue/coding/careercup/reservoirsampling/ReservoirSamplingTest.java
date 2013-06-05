package com.niyue.coding.careercup.reservoirsampling;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ReservoirSamplingTest {

	@Test
	public void testSampleZeroElement() {
		ReservoirSampling sampling = new ReservoirSampling();
		List<Integer> samples = sampling.sample(Arrays.<Integer>asList().iterator(), 0);
		assertThat(samples.size(), is(0));
	}
	
	@Test
	public void testSampleOneElement() {
		ReservoirSampling sampling = new ReservoirSampling();
		List<Integer> samples = sampling.sample(Arrays.<Integer>asList(1).iterator(), 1);
		assertThat(samples, is(Arrays.asList(1)));
	}
	
	@Test
	public void testSampleOneElementFromTwoElements() {
		ReservoirSampling sampling = new ReservoirSampling();
		List<Integer> samples = sampling.sample(Arrays.<Integer>asList(1, 2).iterator(), 1);
		assertThat(samples, anyOf(is(Arrays.asList(1)), is(Arrays.asList(2))));
	}

}
