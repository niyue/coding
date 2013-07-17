package com.niyue.coding.misc.twouniquechars;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * find the longest substring in a given string that is composed of any two unique repeating characters
 * Ex. in an input string "aabadefghaabbaagad", the longest such string is "aabbaa"
 */
public class TwoUniqueChars {
	public String find(String s) {
		Map<Character, Integer> recentPositions = new LinkedHashMap<Character, Integer>();
		int maxStart = 0, maxEnd = -1;
		int start = 0, end = -1;
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(recentPositions.size() < 2) {
				recentPositions.put(c, i);
			} else {
				if(recentPositions.containsKey(c)) {
					recentPositions.put(c, i);
				} else {
					Iterator<Entry<Character, Integer>> positionIterator = recentPositions.entrySet().iterator();
					int firstCharLastPosition = positionIterator.next().getValue();
					start = firstCharLastPosition + 1;
					positionIterator.remove();
					recentPositions.put(c, i);
				}
			}
			end = i;
			if(end - start > maxEnd - maxStart) {
				maxStart = start;
				maxEnd = end;
			}
		}
		return s.substring(maxStart, maxEnd + 1);
	}
}
