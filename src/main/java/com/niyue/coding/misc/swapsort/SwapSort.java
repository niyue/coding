package com.niyue.coding.misc.swapsort;

import java.util.Arrays;

// http://www.mitbbs.com/article_t1/JobHunting/32292525_0_1.html
/*
 * An operation "swap" means removing an element from the array and appending 
 * it at the back of the same array. Find the minimum number of "swaps" needed 
 * to sort that array.
 * Eg :- 3124
 * Output: 2 (3124->1243->1234)
 */
public class SwapSort {
    public int count(int[] numbers) {
        int[] order = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(order);
        int j = 0;
        int increasingCount = 0;
        for(int i = 0; i < order.length; i++) {
        	while(j < numbers.length) {
        		if(order[i] == numbers[j]) {
        			 increasingCount++;
        			 j++;
                     break;
        		}
        		j++;
        	}
            if(j == numbers.length) {
            	break;
            }
        }
        return numbers.length - increasingCount;
    }
}
