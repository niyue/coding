package com.niyue.coding.misc.maxproduct;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MaxProductTest {

	@Test
	public void test1() {
		MaxProduct mp = new MaxProduct();
		int product = mp.maxProduct(1);
		assertThat(product, is(0));
	}
	
	@Test
	public void test2() {
		MaxProduct mp = new MaxProduct();
		int product = mp.maxProduct(2);
		assertThat(product, is(1));
	}
	
	@Test
	public void test3() {
		MaxProduct mp = new MaxProduct();
		int product = mp.maxProduct(3);
		assertThat(product, is(3));
	}
	
	@Test
	public void test4() {
		MaxProduct mp = new MaxProduct();
		int product = mp.maxProduct(4);
		assertThat(product, is(6));
	}

}
