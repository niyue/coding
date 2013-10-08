package com.niyue.coding.careercup.josephusproblem;

/*
 * http://www.careercup.com/question?id=14467673
 * http://en.wikipedia.org/wiki/Josephus_problem
 * f(n, k) = (k + f(n - 1, k)) % n 
 * f(1, k) = 0
 */
public class JosephusProblem {
	public int last(int n, int k) {
		assert n > 0 && k > 1;
		int pos = n == 1 ? 0 : (k + last(n - 1, k)) % n;
		return pos;
	}
}
