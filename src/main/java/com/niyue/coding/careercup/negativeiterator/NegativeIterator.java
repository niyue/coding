package com.niyue.coding.careercup.negativeiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NegativeIterator implements Iterator<Integer> {
	private Iterator<Integer> iter;
	private Integer last;
	
	public NegativeIterator(Iterator<Integer> iter) {
		this.iter = iter;
	}
	
	@Override
	public boolean hasNext() {
		if(last == null) {
			last = nextNegative();
		}
		return last != null;
	}

	@Override
	public Integer next() {
		Integer next = null;
		if(last != null) {
			next = last; 
			last = null;
		} else {
			next = nextNegative();
		}
		if(next == null) {
			throw new NoSuchElementException();
		}
		return next;
	}
	
	private Integer nextNegative() {
		Integer next = null;
		while(iter.hasNext()) {
			Integer number = iter.next();
			if(number < 0) {
				next = number;
				break;
			}
		}
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Remove is not implemented yet.");
	}
}
