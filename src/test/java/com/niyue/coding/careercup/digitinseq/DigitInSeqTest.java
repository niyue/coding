package com.niyue.coding.careercup.digitinseq;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitInSeqTest {

	@Test
	public void testZeroth() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(0, sl.get(0));
	}
	
	@Test
	public void testFirst() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(1, sl.get(1));
	}
	
	@Test
	public void testNineth() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(9, sl.get(9));
	}
	
	@Test
	public void testTenth() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(1, sl.get(10));
	}
	
	@Test
	public void testEleventh() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(0, sl.get(11));
	}
	
	@Test
	public void testTwentyth() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(1, sl.get(20));
	}
	
	@Test
	public void testThirtyth() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(2, sl.get(30));
	}
	
	@Test
	public void testThirtyFirst() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(0, sl.get(31));
	}
	
	@Test
	public void testHundredth() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(5, sl.get(100));
	}
	
	@Test
	public void testNinetySeventh() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(3, sl.get(97));
	}
	
	@Test
	public void test109() {
		DigitInSeq sl = new DigitInSeq();
		assertEquals(9, sl.get(109));
	}
}
