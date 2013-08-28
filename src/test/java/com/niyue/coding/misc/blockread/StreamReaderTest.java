package com.niyue.coding.misc.blockread;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StreamReaderTest {

	@Test
	public void testReadFromOneCharSource() {
		char[] source = new char[] {'0'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[1];
		int length = reader.read(dest, 1);
		assertThat(length, is(1));
		assertThat(dest, is(new char[]{'0'}));
	}
	
	@Test
	public void testReadTwoCharsFromOneCharSource() {
		char[] source = new char[] {'0'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[2];
		int length = reader.read(dest, 2);
		assertThat(length, is(1));
		assertThat(dest[0], is('0'));
	}
	
	@Test
	public void testReadTwoCharsFromTwoCharsSource() {
		char[] source = new char[] {'0', '1'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[2];
		int length = reader.read(dest, 2);
		assertThat(length, is(2));
		assertThat(dest[0], is('0'));
		assertThat(dest[1], is('1'));
	}
	
	@Test
	public void testReadFourCharsFromFourCharsSource() {
		char[] source = new char[] {'0', '1', '2', '3'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[4];
		int length = reader.read(dest, 4);
		assertThat(length, is(4));
		assertThat(dest, is(source));
	}
	
	@Test
	public void testReadFourCharsFromFiveCharsSource() {
		char[] source = new char[] {'0', '1', '2', '3', '4'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[4];
		int length = reader.read(dest, 4);
		assertThat(length, is(4));
		assertThat(dest[0], is('0'));
		assertThat(dest[1], is('1'));
		assertThat(dest[2], is('2'));
		assertThat(dest[3], is('3'));
	}
	
	@Test
	public void testReadFiveCharsFromFourCharsSource() {
		char[] source = new char[] {'0', '1', '2', '3'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[5];
		int length = reader.read(dest, 5);
		assertThat(length, is(4));
		assertThat(dest[0], is('0'));
		assertThat(dest[1], is('1'));
		assertThat(dest[2], is('2'));
		assertThat(dest[3], is('3'));
	}
	
	@Test
	public void testReadFiveCharsFromFiveCharsSource() {
		char[] source = new char[] {'0', '1', '2', '3', '4'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[5];
		int length = reader.read(dest, 5);
		assertThat(length, is(5));
		assertThat(dest[0], is('0'));
		assertThat(dest[1], is('1'));
		assertThat(dest[2], is('2'));
		assertThat(dest[3], is('3'));
		assertThat(dest[4], is('4'));
	}
	
	@Test
	public void testReadTwice() {
		char[] source = new char[] {'0', '1', '2', '3', '4'};
		StreamReader reader = new StreamReader(new BlockReader(source));
		char[] dest = new char[3];
		int length = reader.read(dest, 3);
		assertThat(length, is(3));
		assertThat(dest[0], is('0'));
		assertThat(dest[1], is('1'));
		assertThat(dest[2], is('2'));
		
		length = reader.read(dest, 3);
		assertThat(length, is(2));
		assertThat(dest[0], is('3'));
		assertThat(dest[1], is('4'));
	}

}
