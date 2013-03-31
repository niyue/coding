package com.niyue.coding.leetcode.longestvalidparentheses;

import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_32
// initial attempt to solve the parentheses validation, O(n^2) worst case, too slow to pass large data set
public class Solution {
    public int longestValidParentheses(String s) {
		char[] chars = s.toCharArray();
		Deque<Integer> stack = new LinkedList<Integer>();
		int length = 0;
		int maxLen = 0;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				stack.addFirst(i);
			} else {
				if(!stack.isEmpty()) {
					stack.removeFirst();
					length += 2;
					if(length > maxLen) {
						maxLen = length;
					}
				} else {
					length = 0;
				}
			}
		}        
		if(!stack.isEmpty()) {
			int lastIndex = stack.removeFirst();
			maxLen = Math.max(longestValidParentheses(s.substring(0, lastIndex)), 
					longestValidParentheses(s.substring(lastIndex + 1)));
		}
		return maxLen;
    }
}
