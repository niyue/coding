package com.niyue.coding.misc.integersearchinstring;

/*
 *  http://www.mitbbs.com/article_t/JobHunting/32122887.html
 *  Using binary search to solve this problem with O(lgn * m) complexity, where n is the length of string, and m is the length of key
 *  The idea is doing binary search, for any mid character
 *  	expand to left and right until 
 *  		1) meeting the first white space
 *			2) if the white space is far away and the current number's length is larger than key's length (the number will be definitely larger than the key because it has more digits than the key)
 *		if the valueAtMid == key, it is existed in the string
 *		otherwise, doing binary search for a half accordingly
 */
public class IntegerSearchInString {
	public boolean isExisted(String numbers, int key) {
		return binarySearch(numbers, key);
	}
	
	private boolean binarySearch(String numbers, int key) {
		int start = 0;
		int end = numbers.length() - 1;
		String target = Integer.toString(key);
		int keyLen = target.length();
		while(start <= end) {
			int mid = start + (end - start) / 2;
			int midValue = valueAt(numbers, mid, keyLen);
			if(midValue == key) {
				return true;
			} else if(midValue < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
	
	private int valueAt(String numbers, int mid, int keyLen) {
		char midChar = numbers.charAt(mid);
		if(midChar == ' ') {
			mid++;
		}
		int start = mid;
		while(start >= 0 && numbers.charAt(start) != ' ' && mid - start <= keyLen + 1) {
			start--;
		}
		int end = mid;
		while(end < numbers.length() && numbers.charAt(end) != ' ' && end - start <= keyLen + 1) {
			end++;
		}
		StringBuilder s = new StringBuilder();
		for(int i = start + 1; i < end && i >= 0 && i < numbers.length(); i++) {
			s.append(numbers.charAt(i));
		}
		return Integer.valueOf(s.toString());
	}
}
