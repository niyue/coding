package com.niyue.coding.leetcode.longestvalidparentheses;

import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_32
// Mark matched parentheses in a different place
// two steps: 1) iterate all parentheses, and when a pair of matched parentheses are found, mark both positions as valid
// 2) iterate all parentheses and their marks, count continuous valid marks and find the longest
public class SimpleSolution {
	private static final char VALID = 'V';
	
    public int longestValidParentheses(String s) {
		char[] chars = s.toCharArray();
		Deque<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				stack.addFirst(i);
			} else {
				if(!stack.isEmpty()) {
					// mark both open and close parentheses char position to be valid
					chars[stack.removeFirst()] = VALID;
					chars[i] = VALID;
				}
			}
		}      
		return findLongestContinuousValidParentheses(chars);
    }
    
    private int findLongestContinuousValidParentheses(char[] chars) {
    	int maxLen = 0;
		for(int i = 0, length = 0; i < chars.length; i++) {
			if(chars[i] == VALID) {
				length += 2; // valid parentheses always come in as a pair
				i++;
				if(length > maxLen) {
					maxLen = length;
				}
			} else {
				length = 0;
			}
		}
		return maxLen;
    }
}
