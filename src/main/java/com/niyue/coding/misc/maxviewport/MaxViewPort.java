package com.niyue.coding.misc.maxviewport;

import java.util.Arrays;

// Given a set of points in coordinate system, and a view port, for example, 30 degrees, whose source is in origin point, 
// figure out the maximum number of points can be seen in the view port
// An O(n) solution using line sweeping
public class MaxViewPort {
	// the points in input are given with their polar system angular coordinate
	// the radius is irrelevant in this problem and is ignored
	public int count(double[] points, double viewPort) {
		assert viewPort >= 0 && viewPort < 2 * Math.PI;
		points = sortedContinuousPoints(points);
		
		int max = 0;
		int count = 0; 
		for(int i = 0, j = 0; i < points.length && j < points.length;) {
			while(j < points.length && points[j] - points[i] < viewPort) {
				j++;
				count++;
			}
			if(count > max) {
				max = count;
			}
			i++;
			count--;
		}
		return max;
	}
	
	private double[] sortedContinuousPoints(double[] points) {
		Arrays.sort(points);
		double[] allPoints = Arrays.copyOf(points, points.length * 2);
		for(int i = points.length; i < allPoints.length; i++) {
			allPoints[i] = 2 * Math.PI + points[i - points.length];
		}
		return allPoints;
	}
}
