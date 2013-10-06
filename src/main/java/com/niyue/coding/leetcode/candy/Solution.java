package com.niyue.coding.leetcode.candy;

/*
 * http://oj.leetcode.com/problems/candy/
 * Solve this problem using a d different solution with interviewstreet.candies. This solution only uses constant space
 * Iterate all ratings:
 * 	* candy starts with 1
 *  * if current rating is equal to previous rating, set candy to 1
 *  * if current rating is larger than previous rating, current candy = previous candy + 1
 *  * if current rating is smaller than previous rating:
 * 	 	if previous point is the initial point to decrease (the peak point), save it, and save the candy for peak
 * 		current candy = previous candy - 1
 *  	if current point is the bottom of the decreasing slope, the candy for the bottom should be 1.
 *  		if it is not 1, we need to modify the candies between the bottom and peak. (1 - candy) is the expected difference should be modified for each candy between peak and bottom.
 * 			the candy for peak point may not need modified, the max(candy for peak, modified candy for peak) should be used
 */
public class Solution {
    public int candy(int[] ratings) {
        int total = 0;
        if(ratings.length > 0) {
            total = 1;
            Integer prevRating = ratings[0];
            Integer peakPosition = null;
            Integer peakCandy = null;
            int candy = 1;
            // System.out.format("total: %d, candy: %d\n", total, candy);
            for(int i = 1; i < ratings.length; i++) {
                if(ratings[i] == prevRating) {
                    candy = 1;
                } else if(ratings[i] > prevRating) {
                    candy++;
                } else {
                    if(peakPosition == null) {
                        peakPosition = i - 1;
                        peakCandy = candy;
                    }
                    candy--;
                }           
                total += candy;
                // System.out.format("total: %d, candy: %d\n", total, candy);
                if(isDescreaingBottom(peakPosition, ratings, i)) {
            		total += (1 - candy) * (i - peakPosition + 1);
                	
            		if(peakPosition != 0 && 
                	   ratings[peakPosition - 1] < ratings[peakPosition] && 
                	   peakCandy >= 1 + i - peakPosition) {
            			total -= 1 - candy;
                	}
                	
                    // System.out.format("total: %d\n", total);
                    peakPosition = null;
                    peakCandy = null;
                    candy = 1;
                }
                
                prevRating = ratings[i];
            }
        }
        return total;
    }
    
    private boolean isDescreaingBottom(Integer decreasingPosition, int[] ratings, int i) {
    	return decreasingPosition != null && 
                (i == ratings.length - 1 || i < ratings.length - 1 && ratings[i + 1] >= ratings[i]);
    }
}
