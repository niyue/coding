package com.niyue.coding.careercup.triplestack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class TripleStackTest {

	@Test
	public void testOneNodeOneStack() {
		TripleStack<Integer> stack = new TripleStack<Integer>(5);
		stack.push(0, 1);
		assertThat(stack.pop(0), is(1));
	}
	
	@Test
	public void testTwoNodesOneStack() {
		TripleStack<Integer> stack = new TripleStack<Integer>(5);
		stack.push(0, 1);
		stack.push(0, 2);
		assertThat(stack.pop(0), is(2));
		assertThat(stack.pop(0), is(1));
	}
	
	@Test
	public void testTwoNodesTwoStacks() {
		TripleStack<Integer> stack = new TripleStack<Integer>(5);
		stack.push(0, 1);
		stack.push(0, 2);
		stack.push(1, 3);
		assertThat(stack.pop(0), is(2));
		assertThat(stack.pop(1), is(3));
		assertThat(stack.pop(0), is(1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testPopEmptyStack() {
		TripleStack<Integer> stack = new TripleStack<Integer>(5);
		assertThat(stack.pop(0), is(1));
	}
	
	@Test
	public void testThreeNodesThreeStacks() {
		TripleStack<Integer> stack = new TripleStack<Integer>(5);
		stack.push(0, 1);
		stack.push(1, 4);
		stack.push(0, 2);
		assertThat(stack.pop(0), is(2));
		stack.push(1, 3);
		assertThat(stack.pop(1), is(3));
		assertThat(stack.pop(1), is(4));
		assertThat(stack.pop(0), is(1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testFullStack() {
		TripleStack<Integer> stack = new TripleStack<Integer>(3);
		stack.push(0, 1);
		stack.push(1, 2);
		stack.push(2, 3);
		stack.push(2, 4);
	}
	
	@Test
	@Ignore("unresolved yet")
	public void testComplexNodesThreeStacks() {
		TripleStack<Integer> stack = new TripleStack<Integer>(5);
		stack.push(0, 1);
		assertThat(stack.pop(0), is(1));
		stack.push(1, 4);
		stack.push(0, 2);
		stack.push(1, 3);
		assertThat(stack.pop(1), is(3));
		assertThat(stack.pop(1), is(4));
		stack.push(2, 2);
		
		assertThat(stack.pop(0), is(1));
		assertThat(stack.pop(2), is(2));
	}
}
