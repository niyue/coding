package com.niyue.coding.careercup.syncreader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SyncReaderTest {

	@Test
	public void testSingleChar() {
		SyncReader reader = new SyncReader("0");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testTwoChars() {
		SyncReader reader = new SyncReader("01");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('1'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testThreeChars() {
		SyncReader reader = new SyncReader("000");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testFourChars() {
		SyncReader reader = new SyncReader("0000");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testFiveChars() {
		SyncReader reader = new SyncReader("00000");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testSixChars() {
		SyncReader reader = new SyncReader("000003");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testSixZeros() {
		SyncReader reader = new SyncReader("000000");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testSixZerosAndTwoSyncChars() {
		SyncReader reader = new SyncReader("00000003");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testSyncCharsInMiddle() {
		SyncReader reader = new SyncReader("00000300");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testTwoSetsOfSyncChars() {
		SyncReader reader = new SyncReader("0000030000030");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testLongRunningZerosAndSyncChars() {
		SyncReader reader = new SyncReader("000000030");
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
	
	@Test
	public void testNonZeroChars() {
		SyncReader reader = new SyncReader("b0000003bb");
		assertThat(reader.read(), is('b'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('0'));
		assertThat(reader.read(), is('b'));
		assertThat(reader.read(), is('b'));
		assertThat(reader.read(), is(Character.MIN_VALUE));
	}
}
