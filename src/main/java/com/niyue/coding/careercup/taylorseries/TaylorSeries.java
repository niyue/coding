package com.niyue.coding.careercup.taylorseries;

/*
 * http://www.careercup.com/question?id=7271105
 * Write code to evaluate the value of e^x using the Taylor;s series. 
 * The series was given. e^x = sigma(n => 0..infinity) (x^n / n!)
 * An O(n ) solution was expected with no Overflow.
 */
public class TaylorSeries {
	public double evaluate(double x) {
		int n = 1;
		double sum = 1;
		double epsilon = 0.0000001;
		double diff = Double.MAX_VALUE;
		double xexp = 1;
		long factorial = 1;
		while(diff > epsilon) {
			xexp *= x;
			factorial *= n;
			diff = xexp / factorial;
			sum += diff;
			n++;
		}
		return sum;
	}
}
