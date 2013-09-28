package com.niyue.coding.leetcode.simplifypath;

import java.util.LinkedList;

/*
 * http://oj.leetcode.com/problems/simplify-path/
 */
public class SolutionTwo {
	public String simplifyPath(String path) {
		String[] segments = path.split("/");
		LinkedList<String> stack = new LinkedList<String>();
		for (String segment : segments) {
			if (segment.equals("..")) {
				stack.pollLast();
			} else if (!segment.equals(".") && !segment.equals("")) {
				stack.offerLast(segment);
			}
		}
		StringBuilder s = new StringBuilder();
		for (String segment : stack) {
			s.append("/").append(segment);
		}
		return s.length() == 0 ? "/" : s.toString();
	}
}
