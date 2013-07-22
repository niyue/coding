package com.niyue.coding.misc.minqueue;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MinQueueTest {

	@Test
	public void testMinForOneElement() {
		MinQueue<Integer> queue = new MinQueue<Integer>();
		queue.offer(1);
		assertThat(queue.min(), is(1));
	}
	
	@Test
	public void testMinForTwoElements() {
		MinQueue<Integer> queue = new MinQueue<Integer>();
		queue.offer(2);
		queue.offer(1);
		assertThat(queue.min(), is(1));
	}
	
	@Test
	public void testMinForOfferingThreeElementsAndPollOne() {
		MinQueue<Integer> queue = new MinQueue<Integer>();
		queue.offer(2);
		queue.offer(1);
		queue.offer(3);
		assertThat(queue.poll(), is(2));
		assertThat(queue.min(), is(1));
	}
	
	@Test
	public void testDuplicatedMin() {
		MinQueue<Integer> queue = new MinQueue<Integer>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(1);
		queue.offer(3);
		assertThat(queue.min(), is(1));
		assertThat(queue.poll(), is(1));
		assertThat(queue.min(), is(1));
		assertThat(queue.poll(), is(2));
		assertThat(queue.min(), is(1));
		assertThat(queue.poll(), is(1));
		assertThat(queue.min(), is(3));
	}
}
