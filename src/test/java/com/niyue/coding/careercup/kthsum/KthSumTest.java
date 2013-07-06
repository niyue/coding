package com.niyue.coding.careercup.kthsum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class KthSumTest {

	@Test
	public void test1stSumFor1x1() {
		KthSum ks = new KthSum();
		int kth = ks.find(new int[] {1}, new int[] {2}, 1);
		assertThat(kth, is(3));
	}
	
	@Test
	public void test1stSumFor2x2() {
		KthSum ks = new KthSum();
		int kth = ks.find(new int[] {1, 2}, new int[] {2, 4}, 1);
		assertThat(kth, is(3));
	}
	
	@Test
	public void test2ndSumFor2x2() {
		KthSum ks = new KthSum();
		int kth = ks.find(new int[] {1, 2}, new int[] {3, 5}, 2);
		assertThat(kth, is(5));
	}
}
