package com.niyue.coding.misc.nestedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// http://www.mitbbs.com/article_t1/JobHunting/32281037_0_1.html
// http://www.careercup.com/question?id=17727664
/*
 * Flatten a List<List<Integer>> in Java and implement the hasNext() and next() methods. e.g. [[6,8],4] should return true when at 6, 8 and false at 4.
 */
public class NestedList implements Iterator<Integer> {
	private List<Object> values;
	private Iterator<Object> first;
	private Iterator<Integer> second;
	private Object nextListOrInteger;
	
	public NestedList(Object... objects) {
		this.values = Arrays.asList(objects);
		first = values.iterator();
	}
	
	@Override
	public boolean hasNext() {
		boolean hasNext = false;
		if(second != null) {
			hasNext = true;
		} else {
			if(nextListOrInteger != null) {
				hasNext = true;
			} else {
				nextListOrInteger = nextIntegerOrNonEmptyList(first);
				if(nextListOrInteger != null) {
					hasNext = true;
				}
			}
		}
		return hasNext;
	}
	
	private Object nextIntegerOrNonEmptyList(Iterator<Object> iter) {
		Object result = null;
		while(iter.hasNext()) {
			Object listOrInteger = iter.next();
			if(listOrInteger instanceof Integer) {
				result = listOrInteger;
				break;
			} else {
				@SuppressWarnings("unchecked")
				List<Integer> list = (List<Integer>) listOrInteger;
				if(!list.isEmpty()) {
					result = list;
					break;
				}
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer next() {
		Integer next = null;
		if(hasNext()) {
			if(second != null) {
				next = second.next();
				if(!second.hasNext()) {
					second = null;
				}
			} else {
				if(nextListOrInteger instanceof Integer) {
					next = (Integer) nextListOrInteger;
				} else {
					second = ((List<Integer>) nextListOrInteger).iterator();
					next = second.next();
					if(!second.hasNext()) {
						second = null;
					}
				}
				nextListOrInteger = null;
			}
			return next;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
