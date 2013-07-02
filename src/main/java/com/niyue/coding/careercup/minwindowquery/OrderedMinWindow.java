package com.niyue.coding.careercup.minwindowquery;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// http://www.careercup.com/question?id=3655770
public class OrderedMinWindow {
	private int[] minWindow = new int[] {-1, -1};
	
	public int[] minWindow(List<Integer> numbers, List<Integer> query) {
		Map<Integer, List<Integer>> invertedIndex = invertedIndex(numbers);
		int[] cursors = new int[query.size()];
		minWindow(cursors, 0, -1, invertedIndex, query);
		return minWindow;
	}
	
	private void minWindow(int[] cursors, int i, int startIndex, Map<Integer, List<Integer>> invertedIndex, List<Integer> query) {
		int ci = cursors[i];
		int number = query.get(i);
		List<Integer> indexes = invertedIndex.get(number);
		for(int j = ci; j < indexes.size(); j++) {
			if(indexes.get(j) > startIndex) {
				if(i == query.size() - 1) {
					int start = invertedIndex.get(query.get(0)).get(cursors[0]);
					int end = invertedIndex.get(query.get(i)).get(cursors[i]);
					if(minWindow[0] == -1 || end - start < minWindow[1] - minWindow[0]) {
						minWindow[0] = start;
						minWindow[1] = end;
					}
					cursors[0]++;
					minWindow(cursors, 0, -1, invertedIndex, query);
				} else {
					cursors[i]++;
					minWindow(cursors, i + 1, indexes.get(j), invertedIndex, query);
				}
			}
		}
	}
	
	private Map<Integer, List<Integer>> invertedIndex(List<Integer> numbers) {
		Map<Integer, List<Integer>> invertedIndex = new LinkedHashMap<Integer, List<Integer>>();
		for(int i = 0; i < numbers.size(); i++) {
			int number = numbers.get(i);
			if(!invertedIndex.containsKey(number)) {
				invertedIndex.put(number, new ArrayList<Integer>());
			}
			invertedIndex.get(number).add(i);
		}
		return invertedIndex;
	}
}
