package com.niyue.coding.leetcode.longestvalidparentheses;

import java.util.Deque;
import java.util.LinkedList;

// http://leetcode.com/onlinejudge#question_32
// initial attempt to solve the parentheses validation, O(n)
// push length and OPEN_PARENTHESES into the same stack
public class Solution {
	private static final int OPEN_PARENTHESES = 0;
	
    public int longestValidParentheses(String s) {
		char[] chars = s.toCharArray();
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxLen = 0;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '(') {
				stack.addFirst(OPEN_PARENTHESES);
			} else {
				if(!stack.isEmpty()) {
					int top = stack.removeFirst();
					if(top == OPEN_PARENTHESES) {
						if(!stack.isEmpty() && stack.peekFirst() != OPEN_PARENTHESES) {
							stack.addFirst(stack.removeFirst() + 2);
						} else {
							stack.addFirst(2);
						}
						if(stack.peekFirst() > maxLen) {
							maxLen = stack.peekFirst();
						}
					} else {
						if(!stack.isEmpty()) {
							if(stack.peekFirst() == OPEN_PARENTHESES) {
								stack.removeFirst();
								if(!stack.isEmpty() && stack.peekFirst() != OPEN_PARENTHESES) {
									stack.addFirst(stack.removeFirst() + top + 2);
								} else {
									stack.addFirst(top + 2);
								}
								if(stack.peekFirst() > maxLen) {
									maxLen = stack.peekFirst();
								}
							} else {
								stack.clear();
							}
						}
					}
				}
			}
		}        
		return maxLen;
    }
}
