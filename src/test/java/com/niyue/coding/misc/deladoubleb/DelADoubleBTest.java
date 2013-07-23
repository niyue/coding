package com.niyue.coding.misc.deladoubleb;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class DelADoubleBTest {

	@Test
	public void testAA() {
		DelADoubleB dd = new DelADoubleB();
		String result = dd.process("aa");
		assertThat(result, is(""));
	}
	
	@Test
	public void testAB() {
		DelADoubleB dd = new DelADoubleB();
		String result = dd.process("ab");
		assertThat(result, is("bb"));
	}
	
	@Test
	public void testCAB() {
		DelADoubleB dd = new DelADoubleB();
		String result = dd.process("cab");
		assertThat(result, is("cbb"));
	}
}
