package com.niyue.coding.misc.primepalindrome;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimePalindromeTest {

	@Test
	public void test2() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(2);
		assertThat(primePalindromes, is(Arrays.asList(2)));
	}
	
	@Test
	public void test4() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(4);
		assertThat(primePalindromes, is(Arrays.asList(2, 3)));
	}
	
	@Test
	public void test11() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(11);
		assertThat(primePalindromes, is(Arrays.asList(2, 3, 5, 7, 11)));
	}
	
	@Test
	public void test18() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(18);
		assertThat(primePalindromes, is(Arrays.asList(2, 3, 5, 7, 11)));
	}
	
	@Test
	public void test110() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(110);
		assertThat(primePalindromes, is(Arrays.asList(2, 3, 5, 7, 11, 101)));
	}
	
	@Test
	public void test140() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(140);
		assertThat(primePalindromes, is(Arrays.asList(2, 3, 5, 7, 11, 101, 131)));
	}
	
	@Test
	public void test10million() {
		PrimePalindrome pp = new PrimePalindrome();
		List<Integer> primePalindromes = pp.all(10000000);
		assertThat(primePalindromes.size(), greaterThan(0));
	}
}
