package com.niyue.coding.careercup.nwaymerge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// http://www.careercup.com/question?id=3264661
public class NWayMerge {
	public List<Integer> merge(List<List<Integer>> lists) {
		List<Integer> numbers = new LinkedList<Integer>();
		Queue<Node> queue = new PriorityQueue<Node>();
		List<Integer> cursors = new ArrayList<Integer>();
		for(int i = 0; i < lists.size(); i++) {
			List<Integer> list = lists.get(i);
			if(list.size() > 0) {
				queue.offer(new Node(i, list.get(0)));
				cursors.add(1);
			} else {
				cursors.add(0);
			}
		}
		
		while(!queue.isEmpty()) {
			Node top = queue.poll();
			numbers.add(top.value);
			int listIndex = top.listIndex;
			List<Integer> list = lists.get(listIndex);
			int cursor = cursors.get(listIndex);
			if(cursor < list.size()) {
				queue.offer(new Node(top.listIndex, list.get(cursor)));
				cursors.set(listIndex, cursor + 1);
			}
		}
		return numbers;
	}
	
	private static class Node implements Comparable<Node> {
		public final int listIndex;
		public final int value;
		
		public Node(int listId, int value) {
			this.listIndex = listId;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
}
