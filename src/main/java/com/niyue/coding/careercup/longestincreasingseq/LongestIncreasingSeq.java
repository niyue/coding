package com.niyue.coding.careercup.longestincreasingseq;

import java.util.ArrayList;
import java.util.List;

// count the length of longest increasing subsequence
// http://www.careercup.com/question?id=15499786
public class LongestIncreasingSeq {
	public int lis(List<Integer> seq) {
		List<Integer> max = new ArrayList<Integer>();
		int length = 0;
		for(int i = 0; i < seq.size(); i++) {
			if(i == 0) {
				max.add(i);
				length++;
			} else {
				int n = seq.get(i);
				int pos = binarySearch(max, seq, n);
				if(pos > length - 1) {
					max.add(i);
					length++;
				} else {
					max.set(pos, i);
				}
			}
		}
		return length;
	}
	
	private int binarySearch(List<Integer> max, List<Integer> seq, int n) {
		int start = 0;
		int end = max.size() - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(seq.get(max.get(mid)) < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
}
