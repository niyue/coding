package com.niyue.coding.careercup.primesieve;

import java.util.ArrayList;
import java.util.List;

// Sieve of Eratosthenes
// http://www.careercup.com/question?id=15503766
// http://introcs.cs.princeton.edu/java/14array/PrimeSieve.java.html
// http://www.algolist.net/Algorithms/Number_theoretic/Sieve_of_Eratosthenes
public class PrimeSieve {
	public List<Integer> sieve(int n) {
		List<Boolean> isPrime = all(n);
		isPrime.set(0, false);
		isPrime.set(1, false);
		List<Integer> primes = new ArrayList<Integer>(n / 20);
		int sqrt = (int) Math.sqrt(n);
		for(int i = 2; i <= sqrt; i++) {
			if(isPrime.get(i)) {
				for(int j = i * i; j <= n; j += i) {
					isPrime.set(j, false);
				}
			}
		}
		for(int i = 2; i <= n; i++) {
			if(isPrime.get(i)) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	private List<Boolean> all(int n) {
		List<Boolean> numbers = new ArrayList<Boolean>(n + 1);
		for(int i = 0; i <= n; i++) {
			numbers.add(true);
		}
		return numbers;
	}
}
