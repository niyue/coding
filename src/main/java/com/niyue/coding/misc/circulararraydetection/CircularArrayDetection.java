package com.niyue.coding.misc.circulararraydetection;

import java.util.Arrays;

// http://www.mitbbs.com/article_t/JobHunting/32184907.html
// An Integer array in which each element is the index in the array for next element
// if there is no next element for an element, the index will be null
// Detect if there is a circle in the array
// An O(n) solution by filling an array of visited status by marking visited element with -1 * index
// Originally this was implemented as a O(n^2) solution, to make it O(n), a key observation is if a new node found to linked to another node visited before which has no circle, this new node cannot form a circle as well
// Another O(n) solution is using two HashSet to store the all visited nodes and nodes visited in this round, which is a more clean solution
public class CircularArrayDetection {
	private boolean hasCircle = false;
	public boolean hasCircle(Integer[] indexes) {
		int[] visited = new int[indexes.length];
		Arrays.fill(visited, indexes.length);
		for(int i = 0; i < indexes.length; i++) {
			if(isNotVisited(visited, i)) {
				visit(indexes, i, visited);
				if(hasCircle) {
					break;
				}
			}
		}
		return hasCircle;
	}
	
	private void visit(Integer[] indexes, int i, int[] visited) {
		if(indexes[i] == null) {
			markVisited(visited, i);
		} else if(isVisitedInThisRound(visited, i)) {
			hasCircle = true;
		} else if(isNotVisited(visited, i)) {
			markVisited(visited, i);
			visit(indexes, indexes[i], visited);
		}
	}
	
	private void markVisited(int[] visited, int i) {
		visited[i] = -1 * i;
	}
	
	private boolean isNotVisited(int[] visited, int i) {
		return visited[i] > 0;
	}
	
	private boolean isVisitedInThisRound(int[] visited, int i) {
		return visited[i] == -1 * i;
	}
}
