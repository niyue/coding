package com.niyue.coding.leetcode.palindromepartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_131
// pre-process the string to get all palindromes and store them as (start, end), O(n^2)
// try all possible partition scheme, and use DP to speed up a bit
public class Solution {
	private ArrayList<ArrayList<String>>[] partitionCache;
	
    @SuppressWarnings("unchecked")
	public ArrayList<ArrayList<String>> partition(String s) {
    	partitionCache = new ArrayList[s.length()];
		Map<Integer, List<Integer>> palindromes = palindromes(s);
		ArrayList<ArrayList<String>> partitions = partition(s, 0, palindromes);
		return partitions;
    }

    private ArrayList<ArrayList<String>> partition(String s, int start, Map<Integer, List<Integer>> palindromes) {
    	ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>();
    	if(partitionCache[start] != null) {
    		partitions = partitionCache[start];
    	} else {
    		if(palindromes.containsKey(start)) {
    			List<Integer> ends = palindromes.get(start);
    			for(int end : ends) {
    				String prefixPalindrome = s.substring(start, end + 1);
    				if(end + 1 == s.length()) {
    					ArrayList<String> partition = new ArrayList<String>();
    					partition.add(prefixPalindrome);
    					partitions.add(partition);
    				} else {
    					ArrayList<ArrayList<String>> subPartitions = partition(s, end + 1, palindromes);
    					for(ArrayList<String> subPartition : subPartitions) {
    						ArrayList<String> partition = new ArrayList<String>();
    						partition.add(prefixPalindrome);
    						partition.addAll(subPartition);
    						partitions.add(partition);
    					}    
    				}
    			}
    		}
    		partitionCache[start] = partitions;
    	}
    	return partitions;
    }

    private Map<Integer, List<Integer>> palindromes(String s) {
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	char[] string = s.toCharArray();
    	for(int i = 0; i < string.length; i++) {
    		// odd length palindromes
    		for(int j = 0; i - j >= 0 && i + j < string.length; j++) {
    			if(string[i - j] == string[i + j]) {
    				if(!map.containsKey(i - j)) {
    					map.put(i - j, new LinkedList<Integer>());
    				}
    				map.get(i - j).add(i + j);
    			} else {
    				break;
    			}
    		}
    		// even length palindromes
    		for(int j = 1; i - j + 1 >= 0 && i + j < string.length; j++) {
    			if(string[i - j + 1] == string[i + j]) {
    				if(!map.containsKey(i - j + 1)) {
    					map.put(i - j + 1, new LinkedList<Integer>());
    				}
    				map.get(i - j + 1).add(i + j);
    			} else {
    				break;
    			}
    		}
    	}
    	return map;
    }
}
