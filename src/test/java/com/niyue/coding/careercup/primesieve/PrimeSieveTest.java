package com.niyue.coding.careercup.primesieve;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PrimeSieveTest {

	@Test
	public void test1() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(1);
		assertEquals(0, primes.size());
	}
	
	@Test
	public void test2() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(2);
		assertThat(primes, is(Arrays.asList(2)));
	}
	
	@Test
	public void test3() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(3);
		assertThat(primes, is(Arrays.asList(2, 3)));
	}
	
	@Test
	public void test4() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(4);
		assertThat(primes, is(Arrays.asList(2, 3)));
	}
	
	@Test
	public void test5() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(5);
		assertThat(primes, is(Arrays.asList(2, 3, 5)));
	}
	
	@Test
	public void test10() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(10);
		assertThat(primes, is(Arrays.asList(2, 3, 5, 7)));
	}
	
	@Test
	public void test20() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(20);
		assertThat(primes, is(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)));
	}
	
	@Test
	public void test100() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(100);
		assertThat(primes.size(), is(25));
	}
	
	@Test
	public void test541() {
		PrimeSieve sieve = new PrimeSieve();
		List<Integer> primes = sieve.sieve(541);
		assertThat(primes.size(), is(100));
	}
}

