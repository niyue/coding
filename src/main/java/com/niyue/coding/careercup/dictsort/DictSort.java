package com.niyue.coding.careercup.dictsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

// sort all chars in a string according to a ordered dictionary given
// http://www.careercup.com/question?id=1555570
public class DictSort {
    public String sort(String string, SortedSet<String> dict) {
        Map<Character, Set<Character>> orders = order(dict);
        List<Character> chars = toCharList(string);
        Collections.sort(chars, new DictComparator(orders));
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
    
    private Map<Character, Set<Character>> order(SortedSet<String> dict) {
        Map<Character, Set<Character>> orders = new HashMap<Character, Set<Character>>();
        String prev = null;
        for(String current : dict) {
            if(prev != null) {
                char[] prevChars = prev.toCharArray();
                char[] currentChars = current.toCharArray();
                for(int i = 0; i < prevChars.length && i < currentChars.length; i++) {
                    if(prevChars[i] != currentChars[i]) {
                        if(!orders.containsKey(currentChars[i])) {
                            orders.put(currentChars[i], new HashSet<Character>());
                        }
                        orders.get(currentChars[i]).add(prevChars[i]);
                        break;
                    }
                }
            }
            prev = current;
        }
        return orders;
    }

    private static class DictComparator implements Comparator<Character> {
        private Map<Character, Set<Character>> orders;
        
        public DictComparator(Map<Character, Set<Character>> dictOrder) {
            this.orders = dictOrder;
        }

        public int compare(Character c1, Character c2) {
            if(c1.equals(c2)) {
                return 0;
            } else if(orders.containsKey(c1) && orders.get(c1).contains(c2)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}