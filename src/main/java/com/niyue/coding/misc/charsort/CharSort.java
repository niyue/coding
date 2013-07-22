package com.niyue.coding.misc.charsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * http://stackoverflow.com/questions/6957415/sorting-a-string-using-another-sorting-order-string
 * Given an input string and an order string, 
 * e.g., “house” and “soup”, print out characters in input string according to character order in order string. 
 * For characters in input string but not in order string, output them in the end, their relative order doesn’t matter.
 * So for “house”, “souhe” and “soueh” are valid outputs.
 */
public class CharSort {
	public String sort(String chars, String order) {
		Comparator<Character> comparator = new StringOrderComparator(charOrder(order));
		List<Character> characters = toChars(chars);
		Collections.sort(characters, comparator);
		return toString(characters);
	}
	
	private String toString(List<Character> chars) {
		StringBuilder s = new StringBuilder();
		for(Character c : chars) {
			s.append(c);
		}
		return s.toString();
	}
	
	private List<Character> toChars(String chars) {
		List<Character> characters = new ArrayList<Character>();
		for(char c : chars.toCharArray()) {
			characters.add(c);
		}
		return characters;
	}
	
	private Map<Character, Integer> charOrder(String order) {
		Map<Character, Integer> charOrder = new HashMap<Character, Integer>();
		for(int i = 0; i < order.length(); i++) {
			charOrder.put(order.charAt(i), i);
		}
		return charOrder;
	}
	
	private static class StringOrderComparator implements Comparator<Character> {
		private Map<Character, Integer> charOrder;
		
		public StringOrderComparator(Map<Character, Integer> charOrder) {
			this.charOrder = charOrder;
		}
		
		@Override
		public int compare(Character c1, Character c2) {
			int order = 0;
			if(charOrder.containsKey(c1) && charOrder.containsKey(c2)) {
				order = charOrder.get(c1) - charOrder.get(c2);
			} else if(charOrder.containsKey(c1) || charOrder.containsKey(c2)) {
				order = charOrder.containsKey(c1) ? -1 : 1; 
			} else {
				order = c1.charValue() - c2.charValue();
			}
			return order;
		}
	}
}
