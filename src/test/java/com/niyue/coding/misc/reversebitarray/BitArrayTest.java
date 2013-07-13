package com.niyue.coding.misc.reversebitarray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BitArrayTest {

	@Test
	public void testOneByte() {
		BitArray ba = new BitArray();
		byte[] bytes = ba.reverse(new byte[] {0b0});
		assertThat(bytes, is(new byte[]{0b0}));
	}
	
	@Test
	public void testTwoBytes() {
		BitArray ba = new BitArray();
		byte[] bytes = ba.reverse(new byte[] {0b0000, 0b0001});
		assertThat(bytes, is(new byte[]{0b1000, 0b0000}));
	}
	
	@Test
	public void testThreeBytes() {
		BitArray ba = new BitArray();
		byte[] bytes = ba.reverse(new byte[] {0b0000, 0b1100, 0b0001});
		assertThat(bytes, is(new byte[]{0b1000, 0b0011, 0b0000}));
	}
}
