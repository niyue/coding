package com.niyue.coding.careercup.integerpartition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

// http://www.careercup.com/question?id=3845559
// the solution is O(sum ^ n), could be optimized to O(sum * n) using DP
public class IntegerPartition {
	private List<List<Integer>> partitions;
	public List<List<Integer>> partition(int sum, int n) {
		partitions = new ArrayList<List<Integer>>();
		partition(sum, n, new ArrayDeque<Integer>());
		return partitions;
	}
	
	private void partition(int sum, int n, Deque<Integer> partition) {
		if(sum >= 0 && n >= 0) {
			if(n == 0 && sum == 0) {
				partitions.add(asList(partition));
			} else {
				for(int i = 0; i <= sum; i++) {
					partition.addFirst(i);
					partition(sum - i, n - 1, partition);
					partition.removeFirst();
				}
			}
		}
	}
	
	private List<Integer> asList(Deque<Integer> partition) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i : partition) {
			list.add(i);
		}
		return Collections.unmodifiableList(list);
	}
}
