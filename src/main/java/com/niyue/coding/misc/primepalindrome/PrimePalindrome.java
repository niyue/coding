package com.niyue.coding.misc.primepalindrome;

import java.util.ArrayList;
import java.util.List;

// http://www.mitbbs.com/article_t/JobHunting/32257199.html
public class PrimePalindrome {
	public List<Integer> all(int n) {
		assert n >= 1;
		List<Integer> numbers = new ArrayList<Integer>();
		List<Integer> primes = sieve(n);
		for(int p : primes) {
			if(isPalindrome(p)) {
				numbers.add(p);
			}
		}
		return numbers;
	}
	
	private List<Integer> sieve(int n) {
		int sqrt = (int) Math.sqrt(n);
		Boolean[] isPrime = new Boolean[n + 1];
		for(int i = 2; i <= sqrt; i++) {
			if(isPrime[i] == null) {
				isPrime[i] = true;
				for(int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}
		List<Integer> primes = new ArrayList<Integer>(n / 10);
		for(int i = 2; i < isPrime.length; i++) {
			if(isPrime[i] == null || isPrime[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
	
	private boolean isPalindrome(int x) {
		boolean isPalindrome = true;
		char[] chars = Integer.toString(x).toCharArray();
		for(int i = 0; i < chars.length / 2; i++) {
			if(chars[i] != chars[chars.length - 1 - i]) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}
}
