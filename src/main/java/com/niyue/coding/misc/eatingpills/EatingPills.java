package com.niyue.coding.misc.eatingpills;

/*
 * Given N pills in a bottle. Eat half pill everyday.
 * And you pick one of them from the bottle everyday, if it is a half pill, eat the entire half.
 * If it is a whole pill, split the whole pill into two halves and eat one of them, and put the remaining half back to bottle.
 * Question: in the Dth day, what is the possibility that there are W wholes and H halves pills remained in the bottle?
 * D could be calculated from N, W, H, so it is not given. Namely, calculate P(N, W, H)
 * DP could be used to make it an O(n^2) algorithm
 */
public class EatingPills {
	private int W, H;
	public double possibility(int N, int W, int H) {
		this.W = W;
		this.H = H;
		return p(N, 0);
	}
	
	private double p(int whole, int half) {
		double p = 0;
		if(whole >= W) {
			if(whole == W && half == H) {
				p = 1;
			} else {
				double pwhole = whole / ((whole + half) * 1.0);
				double eatWhole = p(whole - 1, half + 1) * pwhole;
				double eatHalf = 0;
				if(half > 0) {
					double phalf = half / ((whole + half) * 1.0);
					eatHalf = p(whole, half - 1) * phalf;
				}
				p = eatWhole + eatHalf;
			}
		}
		return p;
	}
}
