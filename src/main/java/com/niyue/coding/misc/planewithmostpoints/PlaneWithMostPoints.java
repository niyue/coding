package com.niyue.coding.misc.planewithmostpoints;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32225593.html
 * An O(n^3) solution:
 * Pick any two points O(n^2), for each pair of points t:
 * 		Iterate all other remaining (n - 2) points, for each point p
 * 			plane_points_count = 3 (three points will determine a plane so every plane will at least have three points on it)
 * 			if point p is co-linear with pair t, plane_points_count++
 * 		Create a hash map, whose key is a tuple of points, and value is the number of points in this plane
 * 		Iterate all other remaining (n - 2) points, for each point p
 * 			if point p is NOT co-linear with pair t
 * 				a plane is determined by (t0, t1, p), calculate the intersection point of this plane with x-axis and y-axis
 * 				use (x-axis intersection point, y-axis intersection point, origin point) as tuple
 * 					counting map[tuple] += plane_points_count
 * Iterate all tuples in the map to find the maximum count 
 */
public class PlaneWithMostPoints {

}
