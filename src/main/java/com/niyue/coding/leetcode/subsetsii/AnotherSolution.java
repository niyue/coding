package com.niyue.coding.leetcode.subsetsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnotherSolution {
	private ArrayList<ArrayList<Integer>> subsets;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        subsets = new ArrayList<ArrayList<Integer>>();
        Map<Integer, Integer> count = count(num);
        Arrays.sort(num);
        num = removeDuplicates(num);
        subsets(num, 0, new ArrayList<Integer>(), count);
        return subsets;
    }

    private void subsets(int[] num, int start, List<Integer> elements, Map<Integer, Integer> count) {
    	if(start == num.length) {
    		subsets.add(new ArrayList<Integer>(elements));
    	} else {
    		int maxCount = count.get(num[start]);
    		for(int i = 0; i <= maxCount; i++) {
    			for(int j = 0; j < i; j++) {
    				elements.add(num[start]);
    			}
    			subsets(num, start + 1, elements, count);
    			for(int j = 0; j < i; j++) {
    				elements.remove(elements.size() - 1);
    			}
    		}
    	}
    }

    private Map<Integer, Integer> count(int[] num) {
    	Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    	for(int n : num) {
    		if(count.containsKey(n)) {
    			count.put(n, count.get(n) + 1);
    		} else {
    			count.put(n, 1);
    		}
    	}
    	return count;
    }

    private int[] removeDuplicates(int[] num) {
    	int j = 1;
    	for(int i = 1; i < num.length; i++) {
    		if(num[i] != num[j - 1]) {
    			num[j] = num[i];
    			j++;
    		}
    	}
    	return Arrays.copyOf(num, j);
    }
}