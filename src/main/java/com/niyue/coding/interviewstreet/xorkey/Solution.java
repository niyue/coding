package com.niyue.coding.interviewstreet.xorkey;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
	private Scanner scanner = new Scanner(System.in);
	private int T;
	private int N, Q;
	private int[] X;
	
	public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }
	
	public void solve() {
		T = scanner.nextInt();
		for(int t=0;t<T;t++) {
			getInput();
			Node root = constructTree();
			for(int i=0;i<Q;i++) {
				int number = scanner.nextInt();
				int min = scanner.nextInt()-1;
				int max = scanner.nextInt()-1;
				int[] bits = asBinary(number);
				int maxXorKey = query(root, min, max, bits, 14);
				int maxXor = maxXorKey ^ number;
				System.out.println(maxXor);
			}
		}
	}
	
	private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        X = new int[N];
        for(int i=0;i<N;i++) {
        	X[i] = scanner.nextInt();
        }
    }
	
	private int query(Node node, int min, int max, int[] bits, int bitPosition) {
		int maxXorKey;
		if(bitPosition == -1) {
			maxXorKey = node.getValue();
		}
		else {
			int oppsiteBit = 1 - bits[bitPosition];
			NavigableSet<Integer> oppsiteBits = node.getKeyIndexes(oppsiteBit);
			Node chosenChild = hasIndexInRange(oppsiteBits, min, max) ? node.getChild(oppsiteBit) : node.getChild(bits[bitPosition]);
			maxXorKey = query(chosenChild, min, max, bits, bitPosition-1); 
		}
		return maxXorKey;
	}
	
	private boolean hasIndexInRange(NavigableSet<Integer> keyIndexes, int min, int max) {
		Integer ceiling = keyIndexes.ceiling(min);
		return ceiling != null && ceiling <= max;
	}
	
	private Node constructTree() {
		Node root = new Node();
		for(int i=0;i<N;i++) {
			int key = X[i];
			int[] keyBits = asBinary(key);
			insert(root, keyBits, 14, i);
		}
		return root;
	}
	
	private int[] asBinary(int key) {
		int[] bits = new int[15];
		int i = 0;
		while(key > 0) {
			bits[i] = key % 2;
			key = key >> 1;
        	i++;
		}
		return bits;
	}
	
	private void insert(Node node, int[] keyBits, int bitPosition, int keyIndex) {
		if(bitPosition == -1) {
			node.setValue(X[keyIndex]);
		}
		else {
			int bitSet = keyBits[bitPosition];
			node.addKeyIndex(bitSet, keyIndex);
			insert(node.getOrCreateChild(bitSet), keyBits, bitPosition-1, keyIndex);
		}
	}
	
	private static class Node {
		private int value;
		@SuppressWarnings("unchecked")
		private NavigableSet<Integer>[] keyIndexes = new NavigableSet[]{
			new TreeSet<Integer>(), new TreeSet<Integer>()};
		
		private Node[] children = new Node[2];
		
		public void addKeyIndex(int bit, int keyIndex) {
			keyIndexes[bit].add(keyIndex);
		}
		
		public NavigableSet<Integer> getKeyIndexes(int bit) {
			return keyIndexes[bit];
		}
		
		public Node getOrCreateChild(int childIndex) {
			Node childNode = children[childIndex];
			if(childNode == null) {
				childNode = new Node();
				children[childIndex] = childNode;
			}
			return childNode;
		}
		
		public Node getChild(int childIndex) {
			return children[childIndex];
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("{%s, %s}", keyIndexes[0], keyIndexes[1]);
		}
	}
}
