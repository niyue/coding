package com.niyue.coding.careercup.dictsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

// sort all chars in a string according to a ordered dictionary given
// http://www.careercup.com/question?id=1555570
public class DictSort {
    public String sort(String string, List<String> dict) {
        List<Map<Character, Set<Character>>> orders = orders(dict);
        List<Character> sortedChars = topologicalSort(orders);
        Map<Character, Integer> order = numericalOrder(sortedChars);
        
        List<Character> chars = toCharList(string);
        Collections.sort(chars, new DictComparator(order));
        return toString(chars);
    }
    
    private List<Character> toCharList(String s) {
    	List<Character> chars = new ArrayList<Character>();
    	for(char c : s.toCharArray()) {
    		chars.add(c);
    	}
    	return chars;
    }

    private String toString(List<Character> chars) {
        StringBuilder s = new StringBuilder();
        for(Character c : chars) {
            s.append(c);
        }
        return s.toString();
    }
    
	private List<Map<Character, Set<Character>>> orders(List<String> dict) {
        Map<Character, Set<Character>> order = new HashMap<Character, Set<Character>>();
    	Map<Character, Set<Character>> reversedOrder = new HashMap<Character, Set<Character>>();
        String prev = null;
        for(String current : dict) {
            if(prev != null) {
                char[] prevChars = prev.toCharArray();
                char[] currentChars = current.toCharArray();
                for(int i = 0; i < prevChars.length && i < currentChars.length; i++) {
                    if(prevChars[i] != currentChars[i]) {
                        if(!order.containsKey(currentChars[i])) {
                            order.put(currentChars[i], new HashSet<Character>());
                        }
                        order.get(currentChars[i]).add(prevChars[i]);
                        
                        if(!reversedOrder.containsKey(prevChars[i])) {
                        	reversedOrder.put(prevChars[i], new HashSet<Character>());
                        }
                        reversedOrder.get(prevChars[i]).add(currentChars[i]);
                        break;
                    }
                }
            }
            prev = current;
        }
        return Arrays.asList(order, reversedOrder);
    }
    
    private List<Character> topologicalSort(List<Map<Character, Set<Character>>> orders) {
    	Map<Character, Set<Character>> order = orders.get(0);
    	Map<Character, Set<Character>> reversedOrder = orders.get(1); 
    	Set<Character> startChars = startChars(order, reversedOrder);
    	
    	List<Character> sort = new ArrayList<Character>();
    	Queue<Character> startQueue = new LinkedList<Character>(startChars);
    	while(!startQueue.isEmpty()) {
    		Character c = startQueue.poll();
    		
    		sort.add(c);
    		if(reversedOrder.containsKey(c)) {
    			Set<Character> children = reversedOrder.get(c);
    			for(Character child : children) {
    				if(order.containsKey(child)) {
    					order.get(child).remove(c);
    					if(order.get(child).isEmpty()) {
    						order.remove(child);
    						startQueue.offer(child);
    					}
    				}
    			}
    		}
    	}
    	
    	return sort;
    }
    
    // characters without dependencies
    private Set<Character> startChars(Map<Character, Set<Character>> order, Map<Character, Set<Character>> reversedOrder) {
    	Set<Character> allChars = allChars(order);
    	Set<Character> startChars = new HashSet<Character>(allChars);
    	for(Entry<Character, Set<Character>> entry : reversedOrder.entrySet()) {
    		for(Character c : entry.getValue()) {
    			startChars.remove(c);
    		}
    	}
    	return startChars;
    }
    
    private Set<Character> allChars(Map<Character, Set<Character>> order) {
    	Set<Character> chars = new HashSet<Character>();
    	for(Entry<Character, Set<Character>> entry : order.entrySet()) {
    		chars.add(entry.getKey());
    		chars.addAll(entry.getValue());
    	}
    	return chars;
    }
    
    private Map<Character, Integer> numericalOrder(List<Character> sortedChars) {
    	Map<Character, Integer> numericalOrder = new HashMap<Character, Integer>();
    	for(int i = 0; i < sortedChars.size(); i++) {
    		Character c = sortedChars.get(i);
    		numericalOrder.put(c, i);
    	}
    	return numericalOrder;
    }

    private static class DictComparator implements Comparator<Character> {
        private Map<Character, Integer> orders;
        
        public DictComparator(Map<Character, Integer> dictOrder) {
            this.orders = dictOrder;
        }

        public int compare(Character c1, Character c2) {
        	return orders.get(c1).compareTo(orders.get(c2));
        }
    }
}