package com.niyue.coding.misc.bitcount;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.BitSet;

import org.junit.Test;

public class BitCountTest {

	@Test
	public void testOne() {
		int count = Integer.bitCount(1);
		assertThat(count, is(1));
	}
	
	@Test
	public void testMinusOne() {
		int count = Integer.bitCount(-1);
		assertThat(count, is(32));
	}
	
	@Test
	public void testBitSetCardinality() throws Exception {
		BitSet bit = new BitSet();
		bit.set(0);
		int cardinality = bit.cardinality();
		assertThat(cardinality, is(1));
	}
	
	@Test
	public void testBitSetLength() throws Exception {
		BitSet bit = new BitSet();
		bit.set(0);
		int length = bit.length();
		assertThat(length, is(1));
	}
	
	@Test
	public void testBitSetNextClearBit() throws Exception {
		BitSet bit = new BitSet();
		bit.set(0);
		int position = bit.nextClearBit(0);
		assertThat(position, is(1));
	}
	
	@Test
	public void testBitSetNextSetBit() throws Exception {
		BitSet bit = new BitSet();
		bit.set(0);
		int position = bit.nextSetBit(0);
		assertThat(position, is(0));
		position = bit.nextSetBit(1);
		assertThat(position, is(-1));
	}
}
