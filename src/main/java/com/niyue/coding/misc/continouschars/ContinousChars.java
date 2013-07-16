package com.niyue.coding.misc.continouschars;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// http://www.mitbbs.com/article_t/JobHunting/32407699.html
// "thiis iss a senntencee" => [i, s, n, e]
public class ContinousChars {
	public List<Character> find(String s) {
		Set<Character> chars = new LinkedHashSet<Character>();
		if(s.length() > 0) {
			int max = 1;
			chars.add(s.charAt(0));
			for(int i = 1, count = 1;i < s.length();i++) {
				if(s.charAt(i) == s.charAt(i - 1)) {
					count++;
				} else {
					count = 1;
				}
				if(count == max) {
					chars.add(s.charAt(i));
				} else if(count > max) {
					chars.clear();
					chars.add(s.charAt(i));
					max = count;
				}
			}
		}
		return new ArrayList<Character>(chars);
	}
}
