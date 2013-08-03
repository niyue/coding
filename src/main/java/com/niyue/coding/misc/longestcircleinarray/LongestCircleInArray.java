package com.niyue.coding.misc.longestcircleinarray;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32279127.html
 * A similar problem with circular array detection.
 * An Integer array in which each element is the index in the array for next element
 * if there is no next element for an element, the index will be null
 * Tell what is the longest circle in this array
 * Use two Set to implement this in O(n)
 */
public class LongestCircleInArray {
	
	public int longestCircle(Integer[] indexes) {
		int longestCircle = 0;
		Set<Integer> visitedIndexes = new HashSet<Integer>();
		for(int i = 0; i < indexes.length; i++) {
			if(!visitedIndexes.contains(i)) {
				Set<Integer> visitedIndexesInThisRound = new LinkedHashSet<Integer>();
				Integer j = i;
				while(j != null && !visitedIndexesInThisRound.contains(j)) {
					visitedIndexes.add(j);
					visitedIndexesInThisRound.add(j);
					j = indexes[j];
				}
				if(j != null) {
					int allVisitedIndexesInThisRound = visitedIndexesInThisRound.size();
					int circleStart = 0;
					for(int visited : visitedIndexesInThisRound) {
						if(visited == j) {
							break;
						} else {
							circleStart++;
						}
					}
					int circleLength = allVisitedIndexesInThisRound - circleStart;
					if(circleLength > longestCircle) {
						longestCircle = circleLength;
					}
				}
			}
		}
		return longestCircle;
	}
}
