package com.niyue.coding.misc.missingchars;

import java.util.ArrayList;
import java.util.List;

/*
 * http://www.mitbbs.com/article_t1/JobHunting/32156867_0_1.html
 * Given two strings, the second one is a subsequence of the first one, with several characters missing.
 * Print all the missing characters positions for the second string.
 * f("abc", "ab") => [2]
 * f("abc", "b")  => [0, 2]
 * f("abc", "ac") => [1]
 * f("aab", "ab") => either [0] or [1]  
 */
public class MissingChars {
	public List<Integer> find(String one, String two) {
		List<Integer> missings = new ArrayList<Integer>();
		int i1 = 0, i2 = 0;
		while(i1 < one.length()) {
			if(i2 < two.length() && one.charAt(i1) == two.charAt(i2)) {
				i1++;
				i2++;
			} else {
				missings.add(i1);
				i1++;
			}
		}
		return missings;
	}
}
