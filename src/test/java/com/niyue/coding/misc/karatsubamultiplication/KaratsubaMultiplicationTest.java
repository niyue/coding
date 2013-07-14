package com.niyue.coding.misc.karatsubamultiplication;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import com.niyue.coding.misc.bignummultiplication.KaratsubaMulplication;

public class KaratsubaMultiplicationTest {

	@Test
	public void test1x1() {
		KaratsubaMulplication km = new KaratsubaMulplication();
		BigInteger product = km.multiply(BigInteger.ONE, BigInteger.ONE);
		assertThat(product, is(BigInteger.ONE));
	}

	@Test
	public void test8x8() {
		KaratsubaMulplication km = new KaratsubaMulplication();
		BigInteger product = km.multiply(BigInteger.valueOf(8), BigInteger.valueOf(8));
		assertThat(product, is(BigInteger.valueOf(64)));
	}
	
	@Test
	public void test100x40() {
		KaratsubaMulplication km = new KaratsubaMulplication();
		BigInteger product = km.multiply(BigInteger.valueOf(100), BigInteger.valueOf(40));
		assertThat(product, is(BigInteger.valueOf(4000)));
	}
	
	@Test
	public void testNegativeMultiplication() {
		KaratsubaMulplication km = new KaratsubaMulplication();
		BigInteger product = km.multiply(BigInteger.valueOf(-100), BigInteger.valueOf(40));
		assertThat(product, is(BigInteger.valueOf(-4000)));
	}
	
	@Test
	public void testTwoNegativesMultiplication() {
		KaratsubaMulplication km = new KaratsubaMulplication();
		BigInteger product = km.multiply(BigInteger.valueOf(-100), BigInteger.valueOf(-32));
		assertThat(product, is(BigInteger.valueOf(3200)));
	}
	
	@Test
	public void test0x140() {
		KaratsubaMulplication km = new KaratsubaMulplication();
		BigInteger product = km.multiply(BigInteger.valueOf(0), BigInteger.valueOf(140));
		assertThat(product, is(BigInteger.valueOf(0)));
	}
}
