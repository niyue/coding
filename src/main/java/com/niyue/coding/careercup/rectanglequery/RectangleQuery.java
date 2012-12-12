package com.niyue.coding.careercup.rectanglequery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given a n*n grid map that is parallel with x, y axis, the down left point is (0,0),the up right point is (n,n). 
 * Given n rectangles, the down left point and up right point are (x1,y1)(x1',y1'),..., (xn,yn)(xn',yn'). 
 * xn,yn,xn',yn',n are non-negative integers, and all rectangles are parallel with axis. 
 * Design a query which return, for a specific grid unit (x,y)(x+1,y+1), how many rectangles cover it? 
 * Minimize the time complexity of the query and the pre-processing. 1<n<1000
 * It is essentially a 2D version of this problem, http://www.careercup.com/question?id=14680789
 */
public class RectangleQuery {
	private List<Rectangle> rectangles;
	private NavigableMap<Integer, NavigableMap<Integer, Integer>> xyRectanglesCount;
	
	public RectangleQuery(Rectangle... givenRectangles) {
		preProcess(givenRectangles);
	}
	
	/**
	 * O(n^2) pre-process
	 * 1) get all x-left, x-right for all rectangles, and sort the x axis values together, O(nlgn)
	 * 2) get all y-down, y-up for all rectangles, and sort the y axis values together, O(nlgn)
	 * 3) a line sweeping from the sorted x axis values, for each x value:
	 * 	3.1) if it is the left side of the rectangle, an new rectangle is entering starting this x value
	 * 	3.2) if it is the right side of the rectangle, an existing rectangle is leaving starting this x value
	 * 	we can use a set, initially empty, to track all rectangles that may be currently overlapped (from x axis point of view)
	 * 	for every x value, if 3.1), add the corresponding rectangle to the set, otherwise (3.2), remove the corresponding rectangle from the set.
	 * 	we will get a map (mapping from x value => the set of possible overlapped rectangles from that x value) after iterating all x values. O(n^2) operation
	 * 4) iterate each entry in the map to count the number of overlapped rectangles from Y axis point of view further. 
	 * A TreeMap #1 will be used to store the result for query later
	 * 	for each entry in the map (every X value):
	 * 		initialize a TreeMap #2 to record the number of rectangles for every possible Y (for this X value)
	 * 		a line sweeping from all the sorted y values (obtained in step #2), an integer count, initially 0, will be used to count the overlapped rectangles in this range
	 * 			4.1.1) if the rectangle corresponding to the Y value is contained in the rectangle set in this entry for this X value
	 * 				4.1.1.1) if Y value is the lower side of the rectangle, which means a new rectangle is entering, count++
	 * 				4.1.1.2) if Y value is the higher side of the rectangle, which means an existing rectangle is leaving, count--
	 * 			4.1.2) if the rectangle corresponding to the Y value is not contained in the rectangle set in this entry for this X value, simply skip it
	 * 			put the (y value, count) into the TreeMap #2
	 * 		put the (x value, TreeMap #2) into the TreeMap #1
	 * 
	 * After pre-processing, every possible overlapped rectangles are counted and recorded in the TreeMap #1
	 * a query can be done via two O(lgn) queries (first for TreeMap #1, and second for TreeMap #2 retrieved from TreeMap #1)
	 * @param givenRectangles a list of rectangles given for query against
	 */ 
	public void preProcess(Rectangle... givenRectangles) {
		rectangles = getInputRectangles(givenRectangles);
		
		List<Point> sortedXPoints = sortXPoints();
		List<Point> sortedYPoints = sortYPoints();
		Map<Integer, Set<Rectangle>> rectanglesInXAxis = sweepXAxis(sortedXPoints);
		
		xyRectanglesCount = countRectanglesInEachX(rectanglesInXAxis, sortedYPoints);
	}
	
	private NavigableMap<Integer, NavigableMap<Integer, Integer>> countRectanglesInEachX(Map<Integer, Set<Rectangle>> rectanglesInXAxis, List<Point> sortedYPoints) {
		NavigableMap<Integer, NavigableMap<Integer, Integer>> xyRectanglesCount = new TreeMap<Integer, NavigableMap<Integer, Integer>>();
		for(Entry<Integer, Set<Rectangle>> rectanglesStartingFromX : rectanglesInXAxis.entrySet()) {
			int x = rectanglesStartingFromX.getKey();
			Set<Rectangle> rectanglesFromX = rectanglesStartingFromX.getValue();
			NavigableMap<Integer, Integer> rectanglesCount = sweepYAxisForX(rectanglesFromX, sortedYPoints);
			xyRectanglesCount.put(x, rectanglesCount);
		}
		return xyRectanglesCount;
	}
	
	private NavigableMap<Integer, Integer> sweepYAxisForX(Set<Rectangle> rectanglesFromX, List<Point> sortedYPoints) {
		NavigableMap<Integer, Integer> rectanglesCount = new TreeMap<Integer, Integer>();
		int count = 0;
		for(Point yPoint : sortedYPoints) {
			Rectangle currentRectangle = rectangles.get(yPoint.rectangleId);
			if(rectanglesFromX.contains(currentRectangle)) {
				if(yPoint.isStart) {
					count++;
				} else {
					count--;
				}
				rectanglesCount.put(yPoint.value, count);
			}
		}
		return rectanglesCount;
	}
	
	private List<Rectangle> getInputRectangles(Rectangle... givenRectangles) {
		List<Rectangle> rectangles = new ArrayList<Rectangle>();
		for(int i=0;i<givenRectangles.length;i++) {
			givenRectangles[i].id = i; 
			rectangles.add(givenRectangles[i]);
		}
		return rectangles;
	}
	
	private List<Point> sortXPoints() {
		List<Point> xPoints = new ArrayList<Point>();
		for(Rectangle rectangle : rectangles) {
			Point xStartPoint = new Point(rectangle.downLeftX, rectangle.id, true);
			Point xEndPoint = new Point(rectangle.upRightX, rectangle.id, false);
			xPoints.add(xStartPoint);
			xPoints.add(xEndPoint);
		}
		Collections.sort(xPoints);
		return xPoints;
	}
	
	private List<Point> sortYPoints() {
		List<Point> yPoints = new ArrayList<Point>();
		for(Rectangle rectangle : rectangles) {
			Point yStartPoint = new Point(rectangle.downLeftY, rectangle.id, true);
			Point yEndPoint = new Point(rectangle.upRightY, rectangle.id, false);
			yPoints.add(yStartPoint);
			yPoints.add(yEndPoint);
		}
		Collections.sort(yPoints);
		return yPoints;
	}
	
	private Map<Integer, Set<Rectangle>> sweepXAxis(List<Point> sortedXPoints) {
		Map<Integer, Set<Rectangle>> rectanglesInXAxis = new LinkedHashMap<Integer, Set<Rectangle>>();
		// sweep line algorithm
		Set<Rectangle> currentRectangles = new HashSet<Rectangle>();
		for(Point xPoint : sortedXPoints) {
			Rectangle rectangle = rectangles.get(xPoint.rectangleId);
			if(xPoint.isStart) { // enter a new rectangle
				currentRectangles.add(rectangle);
			} else { // leave a rectangle
				currentRectangles.remove(rectangle);
			}
			// copy all current rectangles into a new set, O(n)
			Set<Rectangle> rectanglesStartingFromX = new HashSet<Rectangle>(currentRectangles);
			rectanglesInXAxis.put(xPoint.value, rectanglesStartingFromX); // O(lgn)
		}
		return rectanglesInXAxis;
	}
	
	/**
	 * An O(lgn) + O(lgn) query operation
	 * @param x the X coordination for the cell
	 * @param y the Y coordination for the cell 
	 * @return the number of rectangles cover the cell [(x,y), (x+1,y+1)]
	 */
	public int query(int x, int y) {
		int count = 0;
		Entry<Integer, NavigableMap<Integer, Integer>> entryStartingFromX = xyRectanglesCount.floorEntry(x);
		if(entryStartingFromX != null) {
			NavigableMap<Integer, Integer> rectanglesMapStartingFromX = entryStartingFromX.getValue();
			Entry<Integer, Integer> rectanglesCountStartingFromY = rectanglesMapStartingFromX.floorEntry(y);
			if(rectanglesCountStartingFromY != null) {
				count = rectanglesCountStartingFromY.getValue();
			}
		}
		return count;
	}
	
	public static class Rectangle {
		public int id;
		public int downLeftX;
		public int downLeftY;
		public int upRightX;
		public int upRightY;
		
		public Rectangle(int downLeftX, int downLeftY, int upRightX,
				int upRightY) {
			super();
			this.downLeftX = downLeftX;
			this.downLeftY = downLeftY;
			this.upRightX = upRightX;
			this.upRightY = upRightY;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			Rectangle other = (Rectangle) obj;
			if (id != other.id)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Rectangle [id=" + id + ", downLeftX=" + downLeftX
					+ ", downLeftY=" + downLeftY + ", upRightX=" + upRightX
					+ ", upRightY=" + upRightY + "]";
		}
	}
	
	public static class Point implements Comparable<Point>{
		public int value;
		public int rectangleId;
		public boolean isStart;
		
		public Point(int value, int rectangleId, boolean isStart) {
			super();
			this.value = value;
			this.rectangleId = rectangleId;
			this.isStart = isStart;
		}
		
		@Override
		public String toString() {
			return "Point [value=" + value + ", rectangleId=" + rectangleId
					+ ", isStart=" + isStart + "]";
		}



		@Override
		public int compareTo(Point p) {
			return this.value - p.value;
		}
	}
}
