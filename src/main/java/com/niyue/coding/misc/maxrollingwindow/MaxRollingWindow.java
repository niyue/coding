package com.niyue.coding.misc.maxrollingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

// http://www.mitbbs.com/article_t/JobHunting/32156867.html
// Given an integer array of numbers and an integer k, sliding a k length window from the zeroth position of the array
// output each max value in the window
// Using a TreeMap, removing old element not in the window and adding new element into the window
// An O(nlgk) solution
public class MaxRollingWindow {
	public List<Integer> search(List<Integer> numbers, int k) {
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for(int i = 0; i < k; i++) {
			if(!map.containsKey(numbers.get(i))) { 
				map.put(numbers.get(i), 0);
			}
			map.put(numbers.get(i), map.get(numbers.get(i)) + 1);
		}
		
		List<Integer> maxes = new ArrayList<Integer>(numbers.size() - k);
		maxes.add(map.lastKey());
		
		for(int i = k; i < numbers.size(); i++) {
			int removed = numbers.get(i - k);
			map.put(removed, map.get(removed) - 1);
			if(map.get(removed) == 0) {
				map.remove(removed);
			}
			
			int newNumber = numbers.get(i);
			if(!map.containsKey(newNumber)) { 
				map.put(newNumber, 0);
			}
			map.put(newNumber, map.get(newNumber) + 1);
			
			maxes.add(map.lastKey());
		}
		return maxes;
	}
}
