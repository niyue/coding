package com.niyue.coding.careercup.kthsum;

import java.util.PriorityQueue;
import java.util.Queue;

// http://www.careercup.com/question?id=7457663
// http://www.careercup.com/question?id=2007663
public class KthSum {
	public int find(int[] a1, int[] a2, int k) {
		assert a1.length > 0 && a2.length > 0;
		Queue<Cell> queue = new PriorityQueue<Cell>();
		Cell upperLeft = new Cell(0, 0, a1[0] + a2[0]);
		queue.offer(upperLeft);
		int kth = 0;
		for(int i = 0; i < k; i++) {
			Cell c = queue.poll();
			kth = c.value;
			if(c.x + 1 < a1.length) {
				Cell c1 = new Cell(c.x + 1, c.y, a1[c.x + 1] + a2[c.y]);
				queue.offer(c1);
			}
			if(c.y + 1 < a2.length) {
				Cell c2 = new Cell(c.x, c.y + 1, a1[c.x] + a2[c.y + 1]);
				queue.offer(c2);
			}
		}
		return kth;
	}
	
	private static class Cell implements Comparable<Cell> {
		public final int x;
		public final int y;
		public final int value;
		public Cell(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		
		@Override
		public int compareTo(Cell o) {
			return this.value - o.value;
		}
	}
}
