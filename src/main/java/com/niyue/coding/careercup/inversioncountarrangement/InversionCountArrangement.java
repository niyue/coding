package com.niyue.coding.careercup.inversioncountarrangement;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/*
 * http://www.careercup.com/question?id=24532662
 * You are given two arrays:
 * the first array contains integers which represent heights of people 
 * and the second array contains how many people are expected to be in front of him who are greater than him in term of height.
 * Example:
 * A: 3 2 1 
 * B: 0 1 1 
 * you are asked to rearrange the first array according to the second array.  
 * In this case, the output should be: 
 * 3 1 2 
 * Here 3 has 0 person in front of him, and 1 has 1 person in front of him who is higher than him, and 2 has 1 person in front of him who is higher than him,
 * and this is exactly the second array[0, 1, 1] requires.
 * 
 * An O(n^2) solution:
 * The key observation is the maximum height will have 0 higher elements on its left
 * At each turn, we assign the current maximum height into some position, the current maximum height should be assigned to the index with count as zero. 
 * If there are multiple elements with count as zero, the right most position should be used.
 * 
 * 1) Sort the heights descendingly
 * 2) Use a stack to hold the positions with 0 count
 * 3) Iterate sorted heights, for each height (which is the current max height):
 * 		3.1) If the stack is empty, from right to left, find a zero position from count array, push it into stack
 * 		3.2) Pop one element from stack, which should be the correct position for the current max height, assign it for the current max height
 * 		3.3) Decrease all the count after current max position, if there is some count becomes zero, push it into stack
 * 
 * There is some O(nlgn) solution using order statistic tree, and it might be possible to use solution like inversion count (modified merge sort) to solve this
 */
public class InversionCountArrangement {
	public List<Integer> arrange(List<Integer> heights, List<Integer> count) {
		Collections.sort(heights, Collections.reverseOrder());
		Deque<Integer> stack = new ArrayDeque<Integer>();
		List<Integer> arrangement = new ArrayList<Integer>(Collections.nCopies(heights.size(), -1));
		int existingZero = count.size();
		for(int i = 0; i < heights.size(); i++) {
			int h = heights.get(i);
			if(stack.isEmpty()) {
				while(existingZero > 0) {
					existingZero--;
					if(count.get(existingZero) == 0) {
						stack.offerFirst(existingZero);
						break;
					}
				}
			}
			int max = stack.pollFirst();
			arrangement.set(max, h);
			for(int j = max + 1; j < count.size(); j++) {
				count.set(j, count.get(j) - 1);
				if(count.get(j) == 0) {
					stack.offerFirst(j);
				}
			}
		}
		return arrangement;
	}
}
