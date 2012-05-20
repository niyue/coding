package com.niyue.coding.interviewstreet.xorkey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Solution {
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024 * 10);
	private int T;
	private int N, Q;
	private int[] X;
	private Map<Integer, int[]> numberBitsMap = new HashMap<Integer, int[]>();
	private final static int MAX_NUM_BITS = 15;
	private final static int MAX_BIT_INDEX = MAX_NUM_BITS - 1;
	
	public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }
	
	public void solve() throws NumberFormatException, IOException {
	    String firstLine = input.readLine();
        T = Integer.parseInt(firstLine);
		for(int t=0;t<T;t++) {
			getInput();
			Node root = constructTree();
			for(int i=0;i<Q;i++) {
			    String[] query = input.readLine().split(" ");
				int number = Integer.parseInt(query[0]);
				int min = Integer.parseInt(query[1]) - 1;
				int max = Integer.parseInt(query[2]) - 1;
				int[] bits = getBits(number);
				int maxXorKey = query(root, min, max, bits, MAX_BIT_INDEX);
				int maxXor = maxXorKey ^ number;
				System.out.println(maxXor);
			}
		}
	}
	
	private void getInput() throws IOException {
	    String[] nnq = input.readLine().split(" ");
        N = Integer.parseInt(nnq[0]);
        Q = Integer.parseInt(nnq[1]);
        X = new int[N];
        String[] numbers = input.readLine().split(" ");
        for(int i=0;i<numbers.length;i++) {
        	X[i] = Integer.parseInt(numbers[i]);
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
			int[] keyBits = getBits(key);
			insert(root, keyBits, MAX_BIT_INDEX, i);
		}
		return root;
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
	}
	
	private int[] getBits(int number) {
        int[] bits = null;
        if(numberBitsMap.containsKey(number)) {
            bits = numberBitsMap.get(number);
        }
        else {
            bits = asBinary(number);
            numberBitsMap.put(number, bits);
        }
        return bits;
    }
	
	private int[] asBinary(int key) {
        int[] bits = new int[MAX_NUM_BITS];
        int i = 0;
        while(key > 0) {
            bits[i] = key & 1;
            key = key >> 1;
            i++;
        }
        return bits;
    }
}
