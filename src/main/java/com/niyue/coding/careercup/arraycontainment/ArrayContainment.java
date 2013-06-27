package com.niyue.coding.careercup.arraycontainment;

// http://www.careercup.com/question?id=7744674
// Search if one array is contained in another array using KMP
public class ArrayContainment {
	private int[] big;
	
	public ArrayContainment(int[] big) {
		this.big = big;
	}
	
	public boolean contains(int[] small) {
		int[] b = preprocess(small);
		boolean contains = search(big, small, b);
		return contains;
	}
	
	private int[] preprocess(int[] small) {
		int i = 0;
		int j = -1;
		int[] b = new int[small.length + 1];
		b[0] = j;
		while(i < small.length) {
			while(j >= 0 && small[i] != small[j]) {
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}
		return b;
	}
	
	private boolean search(int[] big, int[] small, int[] b) {
		int i = 0;
		int j = 0;
		boolean contains = false;
		while(i < big.length) {
			while(j >= 0 && big[i] != small[j]) {
				j = b[j];
			}
			i++;
			j++;
			if(j == small.length) {
				contains = true;
				break;
			}
		}
		return contains;
	}
}
