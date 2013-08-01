package com.niyue.coding.misc.minmaxqueue;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinMaxQueueTest {

	@Test
	public void testOneElement() {
		MinMaxQueue<Integer> queue = new MinMaxQueue<>();
		queue.push(1);
		assertThat(queue.getMin(), is(1));
		assertThat(queue.getMax(), is(1));
		assertThat(queue.pop(), is(1));
	}
	
	@Test
	public void testTwoIncreasingElements() {
		MinMaxQueue<Integer> queue = new MinMaxQueue<>();
		queue.push(1);
		assertThat(queue.getMin(), is(1));
		assertThat(queue.getMax(), is(1));
		queue.push(2);
		assertThat(queue.getMin(), is(1));
		assertThat(queue.getMax(), is(2));
		assertThat(queue.pop(), is(1));
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(2));
		assertThat(queue.pop(), is(2));
	}
	
	@Test
	public void testTwoDecreasingElements() {
		MinMaxQueue<Integer> queue = new MinMaxQueue<>();
		queue.push(2);
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(2));
		queue.push(1);
		assertThat(queue.getMin(), is(1));
		assertThat(queue.getMax(), is(2));
		assertThat(queue.pop(), is(2));
		assertThat(queue.getMin(), is(1));
		assertThat(queue.getMax(), is(1));
		assertThat(queue.pop(), is(1));
	}
	
	@Test
	public void testTwoSameElements() {
		MinMaxQueue<Integer> queue = new MinMaxQueue<>();
		queue.push(2);
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(2));
		queue.push(2);
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(2));
		assertThat(queue.pop(), is(2));
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(2));
		assertThat(queue.pop(), is(2));
	}
	
	@Test
	public void testThreeElements() {
		MinMaxQueue<Integer> queue = new MinMaxQueue<>();
		queue.push(1);
		queue.push(3);
		queue.push(2);
		assertThat(queue.getMin(), is(1));
		assertThat(queue.getMax(), is(3));
		assertThat(queue.pop(), is(1));
		
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(3));
		assertThat(queue.pop(), is(3));
		assertThat(queue.getMin(), is(2));
		assertThat(queue.getMax(), is(2));
		assertThat(queue.pop(), is(2));
	}
}
