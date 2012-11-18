package com.niyue.coding.careercup.frequencystack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FrequencyStackTest {
	
	@Test
	public void testPushAndPop() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushAndPeek() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peek());
	}
	
	@Test
	public void testPushTwiceAndPop() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(0);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyAndPop() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyInerleavinglyAndPop() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyLowFrequencyItemLastAndPop() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(0);
		stack.push(0);
		stack.push(1);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyAndPopTripleTimes() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
	}
	
	@Test
	public void testPushWithEqualFrequency() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(1);
		stack.push(0);
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushThreeElementsWithDifferentFrequency() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(0);
		stack.push(2);
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushAndPopInterleavingly() throws Exception {
		FrequencyStack<Integer> stack = new FrequencyStack<Integer>();
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.pop());
		
		stack.push(2);
		stack.push(0);
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.pop());
		
		stack.push(2);		
		stack.push(2);
		
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
	}
}
