package com.niyue.coding.misc.powerof3;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOf3Test {

	@Test
	public void test1() {
		PowerOf3 p3 = new PowerOf3();
		boolean isPowerOf3 = p3.check(1);
		assertThat(isPowerOf3, is(true));
	}
	
	@Test
	public void test3() {
		PowerOf3 p3 = new PowerOf3();
		boolean isPowerOf3 = p3.check(3);
		assertThat(isPowerOf3, is(true));
	}
	
	@Test
	public void test9() {
		PowerOf3 p3 = new PowerOf3();
		boolean isPowerOf3 = p3.check(9);
		assertThat(isPowerOf3, is(true));
	}
	
	@Test
	public void test19() {
		PowerOf3 p3 = new PowerOf3();
		boolean isPowerOf3 = p3.check(19);
		assertThat(isPowerOf3, is(false));
	}

}
