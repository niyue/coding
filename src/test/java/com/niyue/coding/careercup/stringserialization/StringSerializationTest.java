package com.niyue.coding.careercup.stringserialization;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class StringSerializationTest {

	@Test
	public void testSerialization() {
		StringSerialization ss = new StringSerialization();
		String string = ss.serialize(Arrays.asList("1", "2"));
		assertEquals("['1', '2']", string);
	}
	
	@Test
	public void testSerializationWithComma() {
		StringSerialization ss = new StringSerialization();
		String string = ss.serialize(Arrays.asList("1,", "2"));
		assertEquals("['1,', '2']", string);
	}
	
	@Test
	public void testSerializationWithSingleQuote() {
		StringSerialization ss = new StringSerialization();
		String string = ss.serialize(Arrays.asList("1'b", "2"));
		assertEquals("['1''b', '2']", string);
	}
	
	@Test
	public void testDeserialization() {
		StringSerialization ss = new StringSerialization();
		List<String> strings = ss.deserialize("['1', '2']");
		assertThat(strings, equalTo(Arrays.asList("1", "2")));
	}
	
	@Test
	public void testDeserializationWithQuote() {
		StringSerialization ss = new StringSerialization();
		List<String> strings = ss.deserialize("['1''b', '2']");
		assertThat(strings, equalTo(Arrays.asList("1'b", "2")));
	}
	
	@Test
	public void testDeserializationWithComma() {
		StringSerialization ss = new StringSerialization();
		List<String> strings = ss.deserialize("['1,b', '2']");
		assertThat(strings, equalTo(Arrays.asList("1,b", "2")));
	}
	
	@Test
	public void testDeserializationWithCommaAndSpace() {
		StringSerialization ss = new StringSerialization();
		List<String> strings = ss.deserialize("['1, b', '2']");
		assertThat(strings, equalTo(Arrays.asList("1, b", "2")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeserializationWithContinuousComma() {
		StringSerialization ss = new StringSerialization();
		ss.deserialize("['1, b',, '2']");
	}
	
	@Test
	public void testDeserializationWithMultipleSpace() {
		StringSerialization ss = new StringSerialization();
		List<String> strings = ss.deserialize("['1, b' ,   '2']");
		assertThat(strings, equalTo(Arrays.asList("1, b", "2")));
	}
}
