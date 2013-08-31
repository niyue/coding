package com.niyue.coding.misc.maxviewport;

import java.util.Arrays;

// http://www.mitbbs.com/article_t/JobHunting/32335553.html
// Given a set of points in coordinate system, and a view port, for example, 30 degrees, whose source is in origin point, 
// figure out the maximum number of points can be seen in the view port
// An O(n) solution using line sweeping
public class MaxViewPort {
	// the points in input are given with their polar system angular coordinate
	// the radius is irrelevant in this problem and is ignored
	public int count(double[] points, double viewPort) {
		assert viewPort >= 0 && viewPort < 2 * Math.PI;
		points = sortDoubleContinuousPoints(points);
		
		int max = 0;
		int count = 0; 
		for(int start = 0, end = 0; start < points.length && end < points.length; start++, count--) {
			while(end < points.length && points[end] - points[start] < viewPort) {
				end++;
				count++;
			}
			if(count > max) {
				max = count;
			}
		}
		return max;
	}
	
	// to cover the case [2PI - x, 2PI - x + view port], concatenate the same set of points after 2PI
	private double[] sortDoubleContinuousPoints(double[] points) {
		Arrays.sort(points);
		double[] allPoints = Arrays.copyOf(points, points.length * 2);
		for(int i = points.length; i < allPoints.length; i++) {
			allPoints[i] = 2 * Math.PI + points[i - points.length];
		}
		return allPoints;
	}
}
