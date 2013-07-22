package com.niyue.coding.careercup.phonenumbergrouper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://www.careercup.com/question?id=686684
/* 
 * You are given a String number containing the digits of a 
 * phone number (the number of digits, n, can be any positive integer). 
 * To help you memorize the number, you want to divide it into groups of contiguous digits. 
 * Each group must contain exactly 2 or 3 digits. There are three kinds of groups: 
 * ** Excellent: A group that contains only the same digits. For example, 000 or 77. 
 * ** Good: A group of 3 digits, 2 of which are the same. For example, 030, 229 or 166. 
 * ** Usual: A group in which all the digits are distinct. For example, 123 or 90. 
 * The quality of a group assignment is defined as 
 * 2 × (number of excellent groups) + (number of good groups) 
 * Divide the number into groups such that the quality is maximized. Design an efficient 
 * algorithm to return the solution that maximizes the quality.
 * 
 * Recurrence formula:
 * f(n) = max(f(n - 2) + qualify(2), f(n - 3) + qualify(3))
 * define:
 * qualities[i] denotes the known maximum quality before i, excluding the ith digit
 * O(n) solution with DP, the best grouping is constructed from the qualities array
 */
public class PhoneNumberGrouper {
	public List<String> group(String number) {
		char[] digits = number.toCharArray();
		int[] qualities = new int[digits.length + 1];
		
		for(int i = 2; i <= digits.length; i++) {
			Integer threeDigitsGroupQuality = null;
			Integer twoDigitsGroupQuality = null;
			if(i - 3 >= 0 && i - 3 != 1) {
				threeDigitsGroupQuality = qualities[i - 3] + threeDigitsGroupQuality(digits, i);
			}
			if(i - 2 >= 0 && i - 2 != 1) {
				twoDigitsGroupQuality = qualities[i - 2] + twoDigitsGroupQuality(digits, i);
			}
			if(threeDigitsGroupQuality != null && twoDigitsGroupQuality != null) {
				qualities[i] = Math.max(threeDigitsGroupQuality, twoDigitsGroupQuality);
			} else {
				qualities[i] = threeDigitsGroupQuality == null ? twoDigitsGroupQuality : threeDigitsGroupQuality;
			}
		}
		List<String> groups = new ArrayList<String>();
		for(int i = digits.length; i > 1;) {
			boolean isTwoDigitsGroup = isTwoDigitsGroup(qualities, digits, i);
			int groupSize = isTwoDigitsGroup ? 2 : 3;
			String group = new String(digits, i - groupSize, groupSize); 
			groups.add(group);
			i -= groupSize;
		}
		Collections.reverse(groups);
		return groups;
	}
	
	private boolean isTwoDigitsGroup(int[] qualities, char[] digits, int i) {
		int quality = qualities[i] - twoDigitsGroupQuality(digits, i);
		return i - 2 != 1 && (quality == 0 || quality == qualities[i - 2]);
	}
	
	private int twoDigitsGroupQuality(char[] digits, int i) {
		return digits[i - 1] == digits[i - 2] ? 2 : 0;
	}
	
	private int threeDigitsGroupQuality(char[] digits, int i) {
		int quality = 0;
		if(digits[i - 1] == digits[i - 2] && digits[i - 1] == digits[i - 3]) {
			quality = 2;
		} else if(digits[i - 1] == digits[i - 2] || digits[i - 1] == digits[i - 3] || digits[i - 2] == digits[i - 3]) {
			quality = 1;
		}
		return quality;
	}
}
