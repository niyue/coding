package com.niyue.coding.misc.swapzero;

import java.util.*;

public class Solution {
	/**
	 * 交换数组里n和0的位置
	 * 
	 * @param array
	 *            数组
	 * @param len
	 *            数组长度
	 * @param n和0交换的数
	 */
	// 不要修改以下函数内容
	public void swapWithZero(int[] array, int len, int n) {
		int temp = array[n];
		array[n] = array[0];
		array[0] = temp;
	}

	// 不要修改以上函数内容

	/**
	 * 通过调用swapWithZero方法来排
	 * 
	 * @param array 存储有[0,n)的数组
	 * @param len 数组长度
	 */
	public void sort(int[] array, int len) {
		Map<Integer, Integer> map = numMap(array);
		for (int i = 0; i < len; i++) {
			int x = map.get(i);
			swapWithZero(array, len, x);
			map.put(i, 0);
			map.put(array[x], x);

			swapWithZero(array, len, i);
			map.put(array[0], 0);
			map.put(array[i], i);
		}
	}

	private Map<Integer, Integer> numMap(int[] array) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], i);
		}
		return map;
	}
}
