package com.niyue.coding.careercup.frequencystack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CountStackTest {
	
	@Test
	public void testPushAndPop() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushAndPeek() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.peek());
	}
	
	@Test
	public void testPushTwiceAndPop() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(0);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyAndPop() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyInerleavinglyAndPop() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyLowFrequencyItemLastAndPop() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(0);
		stack.push(0);
		stack.push(1);
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushDifferentFrequencyAndPopTripleTimes() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(0);
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushWithEqualFrequency() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(1);
		stack.push(0);
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
	}
	
	@Test
	public void testPushThreeElementsWithDifferentFrequency() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(0);
		stack.push(2);
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
	}
	
	@Test
	public void testPushAndPopInterleavingly() throws Exception {
		CountStack<Integer> stack = new CountStack<Integer>();
		stack.push(1);
		assertEquals(Integer.valueOf(1), stack.pop());
		
		stack.push(2);
		stack.push(0);
		stack.push(1);
		assertEquals(Integer.valueOf(2), stack.pop());
		
		stack.push(2);		
		stack.push(2);
		
		assertEquals(Integer.valueOf(2), stack.pop());
		assertEquals(Integer.valueOf(0), stack.pop());
		assertEquals(Integer.valueOf(1), stack.pop());
		assertEquals(Integer.valueOf(2), stack.pop());
	}
}
