package com.niyue.coding.misc.mintwoexp;

// http://www.mitbbs.com/article_t/JobHunting/32432949.html
public class MinTwoExp {
	public int search(int a, int b) {
		while(a > b) {
			b <<= 1;
		}
		return b;
	}
}
