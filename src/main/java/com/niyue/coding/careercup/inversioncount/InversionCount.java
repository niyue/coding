package com.niyue.coding.careercup.inversioncount;

import java.util.ArrayList;
import java.util.List;

/*
 * Count smaller elements on right side 
 * eg : [4,12,5,6,1,34,3,2] 
 * o/p [3,5,3,3,0,2,1,0]
 * http://www.careercup.com/question?id=12814662
 * Count inversion using modified merge sort
 * a slightly more efficient implementation, http://www.cs.colorado.edu/~main/applications/Mergesort.java
 */
public class InversionCount {
	private int[] counts;
	public List<Integer> count(List<Integer> numbers) {
		counts = new int[numbers.size()];
		List<Node> nodes = convert(numbers);
		sort(nodes);
		return asList(counts);
	}
	
	private List<Integer> asList(int[] counts) {
		List<Integer> countsList = new ArrayList<Integer>();
		for(int c : counts) {
			countsList.add(c);
		}
		return countsList;
	}
	
	private List<Node> convert(List<Integer> numbers) {
		List<Node> nodes = new ArrayList<Node>();
		for(int i = 0; i < numbers.size(); i++) {
			nodes.add(new Node(i, numbers.get(i)));
		}
		return nodes;
	}
	
	private List<Node> sort(List<Node> numbers) {
		if(numbers.size() > 1) {
			int mid = (numbers.size() - 1) / 2;
			List<Node> leftNodes = sort(numbers.subList(0, mid + 1));
			List<Node> rightNodes = sort(numbers.subList(mid + 1, numbers.size()));
			numbers = merge(leftNodes, rightNodes);
		}
		return numbers;
	}
	
	private List<Node> merge(List<Node> leftNodes, List<Node> rightNodes) {
		int length = leftNodes.size() + rightNodes.size();
		List<Node> mergedNodes = new ArrayList<Node>(length);
		int rightCount = 0;
		for(int i = 0, left = 0, right = 0; i < length; i++) {
			if(left == leftNodes.size()) {
				mergedNodes.add(rightNodes.get(right));
				right++;
			} else if(right == rightNodes.size()) {
				Node leftNode = leftNodes.get(left);
				mergedNodes.add(leftNode);
				left++;
				counts[leftNode.index] += rightCount;
			} else {
				Node leftNode = leftNodes.get(left);
				Node rightNode = rightNodes.get(right);
				if(leftNode.compareTo(rightNode) < 0) {
					mergedNodes.add(leftNodes.get(left));
					left++;
					counts[leftNode.index] += rightCount;
				} else {
					mergedNodes.add(rightNodes.get(right));
					right++;
					rightCount++;
				}
			}
		}
		return mergedNodes;
	}
	
	private static class Node implements Comparable<Node> {
		public final int index;
		public final int value;
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return "(" + index + ", " + value + ")";
		}
	}
}
