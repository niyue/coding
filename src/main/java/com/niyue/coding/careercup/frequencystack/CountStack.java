package com.niyue.coding.careercup.frequencystack;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * http://www.careercup.com/question?id=9786128
 * Implement a stack that pops out the most frequently added item. 
 * Stack supports 3 functions - push, pop,and top. 
 * Give complexity of each functions in your implementation.
 * Use two hash maps to keep the mapping from element => count and count => element set.
 * The key observation is:
 *		if an element has max count in the stack, even if its count get decreased, we don't need to worry about find the next max. 
 *		Its next max count will always be (current max - 1) because even if there is no existing element with count (current max - 1), the max element will have count of (current max - 1)
 * All of the operations can be done in O(1). 
 * One limitation in the implementation: since Set is used in the implementation, for the elements added to the stack, its equal element may be returned (this behavior may be slightly different with traditional stack like Stack/ArrayDeque/LinkedList.
 * This CountStack is different with FrequencyStack implemented in the same package:
 * 	the former pops the most frequently added item depending on the number of times they appear in current stack
 *  however, the latter pops the most frequently added item historically (for example, push(1)-pop(1)-push(1), here 1 are considered added twice instead of once)  
 */
public class CountStack<E> {
	private Map<E, Integer> count = new HashMap<E, Integer>();
	private Map<Integer, Set<E>> elements = new HashMap<Integer, Set<E>>();
	private int maxCount = 0;
	
	public void push(E e) {
		increaseCount(e);
		moveUpElement(e);
	}
	
	public E pop() {
		if(!elements.containsKey(maxCount)) {
			throw new NoSuchElementException();
		}
		E e = elements.get(maxCount).iterator().next();
		decreaseCount(e);
		moveDownElement(e);
		return e;
	}
	
	public E peek() {
		if(!elements.containsKey(maxCount)) {
			throw new NoSuchElementException();
		}
		E e = elements.get(maxCount).iterator().next();
		return e;
	}
	
	private void increaseCount(E e) {
		if(!count.containsKey(e)) {
			count.put(e, 0);
		}
		count.put(e, count.get(e) + 1);
		if(count.get(e) > maxCount) {
			maxCount++;
		}
	}
	
	private void decreaseCount(E e) {
		if(count.get(e) == maxCount && elements.get(maxCount).size() == 1) {
			maxCount--;
		}
		count.put(e, count.get(e) - 1);
		if(count.get(e) == 0) {
			count.remove(e);
		}
	}
	
	private void moveUpElement(E e) {
		int currentCount = count.get(e);
		int oldCount = currentCount - 1;
		if(oldCount > 0) {
			elements.get(oldCount).remove(e);
		}
		if(!elements.containsKey(currentCount)) {
			elements.put(currentCount, new LinkedHashSet<E>());
		}
		elements.get(currentCount).add(e);
	}
	
	private void moveDownElement(E e) {
		int currentCount = count.containsKey(e) ? count.get(e) : 0;
		int oldCount = currentCount + 1;
		elements.get(oldCount).remove(e);
		if(currentCount > 0) {
			if(!elements.containsKey(currentCount)) {
				elements.put(currentCount, new LinkedHashSet<E>());
			}
			elements.get(currentCount).add(e);
		}
		
	}
}
