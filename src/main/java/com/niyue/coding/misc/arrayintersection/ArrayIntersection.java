package com.niyue.coding.misc.arrayintersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given two sorted arrays, find their intersections
 * http://leetcode.com/2010/03/here-is-phone-screening-question-from.html
 */
public class ArrayIntersection {
	/*
	 * O(m + n) solution to intersect two sorted arrays
	 */
	public List<Integer> intersect(int[] a1, int[] a2) {
		int i = 0;
		int j = 0;
		List<Integer> intersection = new ArrayList<Integer>();
		while(i < a1.length && j < a2.length) {
			if(a1[i] < a2[j]) {
				i++;
			} else if(a1[i] == a2[j]) {
				intersection.add(a1[i]);
				i++;
				j++;
			} else {
				j++;
			}
		}
		return intersection;
	}

	/*
	 * cannot handle duplicated elements
	 * O(m * lgn), this may be more efficient to O(m + n) when m << n
	 */
	public List<Integer> binaryIntersect(int[] a1, int[] a2) {
		int[] m = a1.length <= a2.length ? a1 : a2;
		int[] n = a1.length <= a2.length ? a2 : a1;
		List<Integer> intersection = new ArrayList<Integer>();
		for(int x : m) {
			int index = Arrays.binarySearch(n, x);
			if(index >= 0) {
				intersection.add(x);
			}
		}
		return intersection;
	}
}
