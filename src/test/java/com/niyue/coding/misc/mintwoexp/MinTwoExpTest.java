package com.niyue.coding.misc.mintwoexp;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinTwoExpTest {

	@Test
	public void test44() {
		MinTwoExp mte = new MinTwoExp();
		int result = mte.search(4, 4);
		assertThat(result, is(4));
	}
	
	@Test
	public void test58() {
		MinTwoExp mte = new MinTwoExp();
		int result = mte.search(5, 8);
		assertThat(result, is(8));
	}
	
	@Test
	public void test98() {
		MinTwoExp mte = new MinTwoExp();
		int result = mte.search(9, 8);
		assertThat(result, is(16));
	}
}
