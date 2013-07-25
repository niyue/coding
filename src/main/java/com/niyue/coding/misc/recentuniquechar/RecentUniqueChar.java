package com.niyue.coding.misc.recentuniquechar;

import java.util.HashSet;
import java.util.Set;

/*
 * Stream of characters, 
 * at any point you should be able to answer what is the most recent character that happened only once
 * An O(n) solution with O(1) time to check the most recent unique character by using the ReversedIteratingLinkedHashSet
 * Basically, it is a knock off of LinkedHashSet in JDK with iteration order changed from insertion order to reversed insertion order so that the last inserted element will be iterated first
 * Once we have such a data structure to use, it is very easy to solve this problem
 */
public class RecentUniqueChar {
	public char find(char... chars) {
		Set<Character> unique = new ReversedIteratingLinkedHashSet<>();
		Set<Character> duplicated = new HashSet<>();
		for(char c : chars) {
			if(!duplicated.contains(c)) {
				if(unique.contains(c)) {
					unique.remove(c);
					duplicated.add(c);
				} else {
					unique.add(c);
				}
			}
		}
		return unique.isEmpty() ? Character.MIN_VALUE : unique.iterator().next();
	}
}
