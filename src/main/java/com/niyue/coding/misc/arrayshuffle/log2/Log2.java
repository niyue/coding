package com.niyue.coding.misc.arrayshuffle.log2;

// http://www.mitbbs.com/article_t/JobHunting/32207861.html
// Write a function that computes log2() using sqrt()
// binary search: log(1.8) = X, log(sqrt(1 x 2)) = log(1.414) = 1/2 * (log(1) + log(2))
// 1.8 > 1.414 => X > 1/2 * (log(1) + log(2)) => X in 0.5~1 
// => search log(sqrt(1.414 x 2))
public class Log2 {
	private static final double epsilon = 0.0000001;
	public double log2(double n) {
		int sign = 1;
		double log2 = 1;
		if(n > 0) {
			if(n < 1) {
				n = 1 / n;
				sign = -1;
			}
			
			while(n > 2) {
				double sqrt = Math.sqrt(n);
				n = sqrt;
				log2 *= 2; 
			}
			log2 *= binarySearch(n);
			
		} else {
			throw new IllegalArgumentException("n should be a positive number");
		}
		return sign * log2;
	}
	
	private double binarySearch(double n) {
		double low = 1;
		double high = 2;
		double lowLog = 0;
		double highLog = 1;
		double log2 = 0;
		double sqrt = 0;
		do {
			sqrt = Math.sqrt(low * high);
			double mid = (lowLog + highLog) / 2;
			if(n < sqrt) {
				high = sqrt;
				highLog = mid;
			} else {
				low = sqrt;
				lowLog = mid;
			}
			log2 = mid;
		} while(!isClose(n, sqrt));
		return log2;
	}
	
	private boolean isClose(double d1, double d2) {
		return Math.abs(d1 - d2) < epsilon; 
	}
}
