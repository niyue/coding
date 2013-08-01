package com.niyue.coding.misc.circulararraydetection;

import java.util.Arrays;

// An Integer array in which each element is the index in the array for next element
// if there is no next element for an element, the index will be null
// Detect if there is a circle in the array
// An O(n^2) solution by filling an array of visited status by marking visited element with -1 * index
public class CircularArrayDetection {
	private boolean hasCircle = false;
	public boolean hasCircle(Integer[] indexes) {
		int[] visited = new int[indexes.length];
		Arrays.fill(visited, indexes.length);
		for(int i = 0; i < indexes.length; i++) {
			visit(indexes, i, visited);
			if(hasCircle) {
				break;
			}
		}
		return hasCircle;
	}
	
	private void visit(Integer[] indexes, int i, int[] visited) {
		if(indexes[i] == null) {
			markVisited(visited, i);
		} else if(isVisited(visited, i)) {
			hasCircle = true;
		} else {
			markVisited(visited, i);
			visit(indexes, indexes[i], visited);
		}
	}
	
	private void markVisited(int[] visited, int i) {
		visited[i] = -1 * i;
	}
	
	private boolean isVisited(int[] visited, int i) {
		return visited[i] == -1 * i;
	}
}
