package com.niyue.coding.careercup.frequencystack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Implement a stack that pops out the most frequently added item. Stack supports 3 functions - push, pop,and top.
 *
 * all operations perform with O(lgn)
 * @param <E> the class for elements stored in this stack
 */
public class FrequencyStack<E> {
	private SortedMap<Integer, Map<E, Integer>> valueMap = new TreeMap<Integer, Map<E, Integer>>();
	private Map<E, Integer> pushFrequency = new HashMap<E, Integer>();
	
	public void push(E value) {
		if(pushFrequency.containsKey(value)) {
			int frequency = pushFrequency.get(value);
			// increase an item's added frequency
			int increasedFrequency = frequency + 1;
			pushFrequency.put(value, increasedFrequency);
			
			// retrieve the number of times this item remains in the stack
			int existingValueCount = 0;
			if(valueMap.containsKey(frequency)) {
				Map<E, Integer> valueCount = valueMap.get(frequency);
				if(valueCount.containsKey(value)) {
					existingValueCount = valueCount.get(value);
					valueCount.remove(value);
					if(valueCount.isEmpty()) {
						valueMap.remove(frequency);
					}
				}
			}
			if(!valueMap.containsKey(increasedFrequency)) {
				valueMap.put(increasedFrequency, new LinkedHashMap<E, Integer>());
			}
			// this item appears in the stack for (existingValueCount + 1) times with (increasedCount) added frequency
			valueMap.get(increasedFrequency).put(value, existingValueCount + 1);
		} else {
			int frequency = 1;
			pushFrequency.put(value, frequency);
			if(!valueMap.containsKey(frequency)) {
				valueMap.put(frequency, new LinkedHashMap<E, Integer>());
			}
			valueMap.get(frequency).put(value, 1);
		}
	}
	
	public E pop() {
		int mostFrequentlyAddedCount = valueMap.lastKey();
		Map<E, Integer> valueCount = valueMap.get(mostFrequentlyAddedCount);
		E mostedFrequentlyAddedItem = valueCount.keySet().iterator().next();
		int remainingCount = valueCount.get(mostedFrequentlyAddedItem) - 1;
		if(remainingCount == 0) {
			valueCount.remove(mostedFrequentlyAddedItem);
			if(valueCount.size() == 0) {
				valueMap.remove(mostFrequentlyAddedCount);
			}
		} else {
			valueCount.put(mostedFrequentlyAddedItem, remainingCount);
		}
		return mostedFrequentlyAddedItem;
	}
	
	public E peek() {
		int mostFrequentlyAddedCount = valueMap.lastKey();
		Map<E, Integer> valueCount = valueMap.get(mostFrequentlyAddedCount);
		E mostedFrequentlyAddedItem = valueCount.keySet().iterator().next();
		return mostedFrequentlyAddedItem;
	}
}