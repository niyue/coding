package com.niyue.coding.careercup.twentyfourpoints;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class PermutationTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testOneNumber() {
		Permutation p = new Permutation();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1)	
		)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testTwoNumbers() {
		Permutation p = new Permutation();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(2, 1)
		)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testTwoDuplicatedNumbers() {
		Permutation p = new Permutation();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 1));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 1),
			Arrays.asList(1, 1)
		)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testThreeNumbers() {
		Permutation p = new Permutation();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2, 3));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(1, 3, 2),
			Arrays.asList(2, 1, 3),
			Arrays.asList(2, 3, 1),
			Arrays.asList(3, 1, 2),
			Arrays.asList(3, 2, 1)
		)));
	}
}
