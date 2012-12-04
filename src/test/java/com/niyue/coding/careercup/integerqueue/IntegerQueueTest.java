package com.niyue.coding.careercup.integerqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerQueueTest {

	@Test
	public void testEnqueueAndDequeue() {
		IntegerQueue queue = new IntegerQueue();
		queue.enqueue(2);
		assertEquals(1, queue.length());
		assertEquals(2, queue.dequeue());
	}
	
	@Test
	public void testEnqueueDequeueTwice() {
		IntegerQueue queue = new IntegerQueue();
		queue.enqueue(3);
		queue.enqueue(4);
		assertEquals(2, queue.length());
		assertEquals("##############34", queue.toString());
		assertEquals(3, queue.dequeue());
		assertEquals("###############4", queue.toString());
	}
	
	@Test
	public void testEnqueueDequeueMultipleTimes() {
		IntegerQueue queue = new IntegerQueue();
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(3, queue.length());
		assertEquals("#############345", queue.toString());
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());
		assertEquals("###############5", queue.toString());
		assertEquals(5, queue.dequeue());
		assertEquals(0, queue.length());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testDequeueEmptyQueue() throws Exception {
		IntegerQueue queue = new IntegerQueue();
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEnqueueBigNumber() throws Exception {
		IntegerQueue queue = new IntegerQueue();
		queue.enqueue(10);
	}
	
	@Test
	public void testFullQueue() throws Exception {
		IntegerQueue queue = new IntegerQueue();
		for(int i=0;i<16;i++) {
			queue.enqueue(i % 10);
		}
		assertEquals(16, queue.length());
		assertTrue(queue.isFull());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testQueueOverflow() throws Exception {
		IntegerQueue queue = new IntegerQueue();
		for(int i=0;i<17;i++) {
			queue.enqueue(i % 10);
		}
	}
}
