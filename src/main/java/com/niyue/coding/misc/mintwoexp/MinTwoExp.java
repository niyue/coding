package com.niyue.coding.misc.mintwoexp;

// http://www.mitbbs.com/article_t/JobHunting/32432949.html
public class MinTwoExp {
	public int search(int a, int b) {
		return shiftOnceMethod(a, b);
	}
	
	@SuppressWarnings("unused")
	private int shiftLoopMethod(int a, int b) {
		while(a > b) {
			b <<= 1;
		}
		return b;
	}
	
	// http://stackoverflow.com/questions/1815741/finding-highest-order-1-in-a-java-primitive
	private int shiftOnceMethod(int a, int b) {
		if(a > b) {
			b = Integer.highestOneBit(a) << 1;
		}
		return b;
	}
}
