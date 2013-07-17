package com.niyue.coding.careercup.twentyfourpoints;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class PermutationTest {

	@Test
	public void testOneNumber() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1)	
		)));
	}
	
	@Test
	public void testTwoNumbers() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(2, 1)
		)));
	}
	
	@Test
	public void testTwoDuplicatedNumbers() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 1));
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 1),
			Arrays.asList(1, 1)
		)));
	}
	
	@Test
	public void testThreeNumbers() {
		Permutation<Integer> p = new Permutation<Integer>();
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
	
	@Test
	public void testPermute10() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1), 0);
		assertThat(permutations, is(Arrays.asList(
			Arrays.<Integer>asList()
		)));
	}
	
	@Test
	public void testPermute11() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1), 1);
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1)
		)));
	}
	
	@Test
	public void testPermute21() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2), 1);
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1),
			Arrays.asList(2)
		)));
	}
	
	@Test
	public void testPermute22() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2), 2);
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(2, 1)
		)));
	}
	
	@Test
	public void testPermute30() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2, 3), 0);
		assertThat(permutations, is(Arrays.asList(
			Arrays.<Integer>asList()
		)));
	}
	
	@Test
	public void testPermute31() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2, 3), 1);
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1),
			Arrays.asList(2),
			Arrays.asList(3)
		)));
	}
	
	@Test
	public void testPermute32() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2, 3), 2);
		assertThat(permutations, is(Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(1, 3),
			Arrays.asList(2, 1),
			Arrays.asList(2, 3),
			Arrays.asList(3, 1),
			Arrays.asList(3, 2)
		)));
	}
	
	@Test
	public void testPermute33() {
		Permutation<Integer> p = new Permutation<Integer>();
		List<List<Integer>> permutations = p.permute(Arrays.asList(1, 2, 3), 3);
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
