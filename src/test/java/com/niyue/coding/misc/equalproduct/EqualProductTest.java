package com.niyue.coding.misc.equalproduct;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EqualProductTest {

	@Test
	public void test1() {
		EqualProduct ep = new EqualProduct();
		List<List<Integer>> solutions = ep.find(1);
		assertThat(solutions.size(), is(1));
		assertThat(solutions.get(0), is(Arrays.asList(1, 1, 1, 1)));
	}
	
	@Test
	public void test2() {
		EqualProduct ep = new EqualProduct();
		List<List<Integer>> solutions = ep.find(2);
		assertThat(solutions.size(), is(6));
		assertThat(solutions.get(0), is(Arrays.asList(1, 1, 1, 1)));
		assertThat(solutions.get(1), is(Arrays.asList(1, 2, 1, 2)));
		assertThat(solutions.get(2), is(Arrays.asList(1, 2, 2, 1)));
		assertThat(solutions.get(3), is(Arrays.asList(2, 1, 1, 2)));
		assertThat(solutions.get(4), is(Arrays.asList(2, 1, 2, 1)));
		assertThat(solutions.get(5), is(Arrays.asList(2, 2, 2, 2)));
	}

}
