package com.niyue.coding.misc.longestcontinuoussubarray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// http://www.mitbbs.com/article_t/JobHunting/32191139.html
// O(n^2) solution, i is the starting element index, j is the ending element index
// if the number of distinct elements between i and j is the same as max - min between i and j
public class LongestContinuousSubarray {
	public List<Integer> find(List<Integer> numbers) {
		int maxStart = 0;
		int maxEnd = -1;
		for(int i = 0; i < numbers.size(); i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			Set<Integer> set = new HashSet<Integer>();
			for(int j = i; j < numbers.size(); j++) {
				int number = numbers.get(j);
				set.add(number);
				if(number > max) {
					max = number;
				}
				if(number < min) {
					min = number;
				}
				if(set.size() == max - min + 1 && set.size() > maxEnd - maxStart + 1) {
					maxStart = i;
					maxEnd = j;
				}
			}
		}
		return numbers.subList(maxStart, maxEnd + 1);
	}
}
