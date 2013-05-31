package com.niyue.coding.careercup.longestincreasingseq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// count the length of longest increasing subsequence
// http://www.careercup.com/question?id=15499786
public class LongestIncreasingSeq {
	public List<Integer> lis(List<Integer> seq) {
		List<Deque<Node>> max = new ArrayList<Deque<Node>>();
		int length = 0;
		for(int i = 0; i < seq.size(); i++) {
			int n = seq.get(i);
			int pos = binarySearch(max, seq, n);
			Node prev = pos == 0 ? null : max.get(pos - 1).peekFirst();
			Node maxNode = new Node(i, prev);
			if(pos > length - 1) {
				Deque<Node> nodes = new LinkedList<Node>();
				nodes.add(maxNode);
				max.add(nodes);
				length++;
			} else {
				max.get(pos).addFirst(maxNode);
			}
		}
		List<Integer> lis = new ArrayList<Integer>();
		Node maxLengthNode = max.get(max.size() - 1).peekFirst();
		while(maxLengthNode != null) {
			lis.add(seq.get(maxLengthNode.value));
			maxLengthNode = maxLengthNode.prev;
		}
		Collections.reverse(lis);
		return lis;
	}
	
	private int binarySearch(List<Deque<Node>> max, List<Integer> seq, int n) {
		int start = 0;
		int end = max.size() - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(seq.get(max.get(mid).peekFirst().value) < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}
	
	private static class Node {
		public final int value;
		public final Node prev;
		public Node(int value, Node prev) {
			this.value = value;
			this.prev = prev;
		}
	}
}
