package com.niyue.coding.careercup.integerqueue;

/**
 * A queue implementation using single integer as storage
 * this should store value 0 to 9. 
 * Example suppose queue has first value 2 then insert 4 then 6 so it should look like 246. 
 * First value should be popped as 2. then it should be 46. 
 * program should support 0 in all the levels also. 
 * example queue should handle like 01235 also, 0 as first value in queue. 
 * remember 0 just to use integer, nothing else as data storage.
 */
public class IntegerQueue {
	private long queue = 0;
	private int MAX_LENGTH = 64 / 4;
	
	private static int[] hex = new int[] {0xa, 0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9};
	
	public void enqueue(int value) {
		if(value < 0 || value > 9) {
			throw new IllegalArgumentException("The enqueue item is out of range. It should be a number from 0 to 9");
		}
		if(!isFull()) {
			int hexValue = hex[value];
			queue = queue << 4 | hexValue;
		} else {
			throw new IllegalStateException("The queue is full.");
		}
	}
	
	public int dequeue() {
		int length = 0;
		int top = 0;
		for(long f=0xf000000000000000L;f != 0;f >>>= 4, length++) {
			if((queue & f) != 0) {
				top = valueForBitSet(f, length);
				queue = queue & (~f);
				break;
			}
		}
		
		if(top != 0) {
			return top % 10;
		} else {
			throw new IllegalStateException("The queue is empty");
		}
	}
	
	private int valueForBitSet(long f, int length) {
		int bitsToShift = (MAX_LENGTH - length - 1) * 4;
		return (int) ((queue & f) >>> bitsToShift);
	}
	
	public boolean isFull() {
		return length() == MAX_LENGTH;
	}
	
	public int length() {
		int length = 0;
		for(long f=0xfL;f != 0;f <<= 4) {
			if((queue & f) != 0) {
				length++;
			} else {
				break;
			}
		}
		return length;
	}

	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		int length = 0;
		int top = 0;
		for(long f=0xf000000000000000L;f != 0;f >>>= 4, length++) {
			if((queue & f) != 0) {
				top = valueForBitSet(f, length);
				string.append(top % 10);
			} else {
				string.append("#");
			}
		}

		return string.toString();
	}
}
