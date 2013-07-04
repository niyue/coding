package com.niyue.coding.careercup.buildingsilhouette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

// http://www.careercup.com/question?id=3514054
public class BuildingSilhouette {
	public List<Skyline> find(List<Skyline> buildings) {
		List<Point> points = convert(buildings);
		NavigableSet<Skyline> tree = new TreeSet<Skyline>(new HighComparator());
		List<Skyline> result = new ArrayList<Skyline>();
		for(int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			if(p.isStart) {
				if(hasOverlappedSkyline(tree)) {
					if(isHigherSkyline(p.skyline, tree.last())) {
						lastSkyline(result).end = p.skyline.start;
						addNewSkyline(result, p.skyline.start, p.skyline.high);
					}
				} else {
					addNewSkyline(result, p.skyline.start, p.skyline.high);
				}
				tree.add(p.skyline);
			} else {
				tree.remove(p.skyline);
				if(hasOverlappedSkyline(tree)) {
					Skyline nextHigh = tree.last();
					if(isHigherSkyline(p.skyline, nextHigh)) {
						lastSkyline(result).end = p.skyline.end;
						addNewSkyline(result, p.skyline.end, nextHigh.high);
					}
				} else {
					lastSkyline(result).end = p.skyline.end;
				}
			}
		}
		
		return merge(result);
	}
	
	private void addNewSkyline(List<Skyline> result, int start, int high) {
		Skyline s = new Skyline();
		s.start = start;
		s.high = high;
		result.add(s);
	}
	
	private boolean isHigherSkyline(Skyline current, Skyline highest) {
		return current.high > highest.high;
	}

	private Skyline lastSkyline(List<Skyline> result) {
		return result.get(result.size() - 1);
	}
	
	private boolean hasOverlappedSkyline(NavigableSet<Skyline> tree) {
		return !tree.isEmpty();
	}
	
	private List<Point> convert(List<Skyline> buildings) {
		List<Point> points = new ArrayList<Point>();
		for(Skyline s : buildings) {
			Point t = new Point();
			t.isStart = true;
			t.skyline = s;
			points.add(t);
			
			Point e = new Point();
			e.isStart = false;
			e.skyline = s;
			points.add(e);
		}
		Collections.sort(points);
		return points;
	}
	
	private List<Skyline> merge(List<Skyline> skylines) {
		List<Skyline> result = new ArrayList<Skyline>();
		if(!skylines.isEmpty()) {
			result.add(skylines.get(0));
		}
		for(int i = 1; i < skylines.size(); i++) {
			Skyline current = skylines.get(i);
			Skyline prev = result.get(i - 1);
			if(current.start == prev.end && current.high == prev.high) {
				prev.end = current.end;
			} else {
				result.add(current);
			}
		}
		return result;
	}
	
	public static class Skyline {
		public int start;
		public int end;
		public int high;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + high;
			result = prime * result + start;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Skyline other = (Skyline) obj;
			if (end != other.end)
				return false;
			if (high != other.high)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + ", high="+ high + "]";
		}
	}
	
	private static class Point implements Comparable<Point> {
		public boolean isStart;
		public Skyline skyline;
		
		private int value() {
			return isStart ? skyline.start : skyline.end;
		}
		
		@Override
		public int compareTo(Point o) {
			return value() - o.value();
		}
	}
	
	private static class HighComparator implements Comparator<Skyline> {
		
		@Override
		public int compare(Skyline s1, Skyline s2) {
			return s1.high - s2.high != 0 ? s1.high - s2.high : s1.start - s2.start != 0 ? s1.start - s2.start : s1.end - s2.end ;
		}
	}
}
