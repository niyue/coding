package com.niyue.coding.misc.integerstreamiterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * A list of integers are compressed and stored as a list of pairs.
 * For example, integers stream like 1,1,2,2,4,4,4,4 is expressed as (1,2)(2,2)(4,4)
 * Write a Java Iterator to iterate this list of integers.
 */
public class IntegerStreamIterator implements Iterator<Integer> {
	private Iterator<IntegerCount> countIterator;
	private IntegerCount currentIntegerCount;
	private int currentCount; 
	
	public IntegerStreamIterator(List<IntegerCount> counts) {
		countIterator = counts.iterator();
	}

	@Override
	public boolean hasNext() {
		return currentIntegerCount != null || countIterator.hasNext();
	}

	@Override
	public Integer next() {
		if(hasNext()) {
			Integer next = null;
			if(currentIntegerCount == null) {
				currentIntegerCount = countIterator.next();
			}
			next = getNext();
			return next;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	private int getNext() {
		int next = currentIntegerCount.integer;
		currentCount++;
		if(currentCount == currentIntegerCount.count) {
			currentIntegerCount = null;
			currentCount = 0;
		}
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	public static class IntegerCount {
		public final int integer;
		public final int count;
		public IntegerCount(int integer, int count) {
			this.integer = integer;
			this.count = count;
		}
	}
}
