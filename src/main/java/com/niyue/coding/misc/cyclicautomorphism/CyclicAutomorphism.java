package com.niyue.coding.misc.cyclicautomorphism;

/*
 * For a string with length n, it has n different shifted strings.
 * A cyclic automorphism is a shifted string which is the same as the original string.
 * Given a string, count how many cyclic automorphism strings it has.
 * For example, given string "byebye", it has 6 different shifted strings:
 * byebye 0 shift/yebyeb 1 shift/ebyeby 2 shift/byebye 3 shift/yebyeb 4 shift/ebyeby 5 shift
 * The cyclic automorphism count for "byebye" should be 2.
 * Use KMP, double the given string to be SS, search the number of times S appeared in SS.
 */
public class CyclicAutomorphism {
	public int count(String s) {
		int[] b = preprocess(s);
		int count = search(s + s, s, b);
		return count;
	}
	
	private int[] preprocess(String pattern) {
		int[] b = new int[pattern.length() + 1];
		int i = 0;
		int j = -1;
		b[0] = j;
		while(i < pattern.length()) {
			while(j >= 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		return b;
	}
	
	private int search(String text, String pattern, int[] b) {
		int i = 0;
		int j = 0;
		int count = -1;
		while(i < text.length()) {
			while(j >= 0 && pattern.charAt(j) != text.charAt(i)) {
				j = b[j];
			}
			i++;
			j++;
			if(j == pattern.length()) {
				count++;
				j = b[j];
			}
		}
		return count;
	}
}
