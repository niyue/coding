package com.niyue.coding.careercup.discintersection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://www.careercup.com/question?id=9616086
public class DiscIntersection {
	public int count(int[] discs) {
		List<Point> points = convert(discs);
		int total = 0;
		int count = 0;
		for(Point p : points) {
			if(p.isStart) {
				count++;
				if(count >= 2) {
					total += count - 1;
				}
			} else {
				count--;
			}
		}
		return total;
	}
	
	private List<Point> convert(int[] discs) {
		List<Point> points = new ArrayList<Point>();
		for(int i = 0; i < discs.length; i++) {
			points.add(new Point(i - discs[i], true));
			points.add(new Point(i + discs[i], false));
		}
		Collections.sort(points);
		return points;
	}
	
	private static class Point implements Comparable<Point> {
		public int value;
		public boolean isStart;
		public Point(int value, boolean isStart) {
			this.value = value;
			this.isStart = isStart;
		}
		
		@Override
		public int compareTo(Point p1) {
			return this.value - p1.value;
		}
	}
}
