package com.niyue.coding.careercup.sum15;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class Sum15Test {

	@Test
	public void test12345() {
		Sum15 sum = new Sum15();
		int count = sum.find(new int[] {1, 2, 3, 4, 5});
		assertThat(count, is(1));
	}
	
	@Test
	public void test551023() {
		Sum15 sum = new Sum15();
		int count = sum.find(new int[] {5, 5, 10, 2, 3});
		assertThat(count, is(4));
	}
	
	@Test
	public void test55555() {
		Sum15 sum = new Sum15();
		int count = sum.find(new int[] {5, 5, 5, 5, 5});
		assertThat(count, is(10));
	}
}
