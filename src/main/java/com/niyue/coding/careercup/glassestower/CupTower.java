package com.niyue.coding.careercup.glassestower;

/*
 * http://www.careercup.com/question?id=12770661
 *         |_| 
 *       |_| |_| 
 *     |_| |_| |_| 
 *   |_| |_| |_| |_| 
 * |_| |_| |_| |_| |_| 

 * Each cup has capacity C and once a cup gets full, it drops half extra amount to left child and half extra amount to right child 
 * for Eg : let' first cups get 2C amount of liquid then extra amount C(2C-C) will be divided equally to left and right child cup of next level 
 * i.e. C/2 to left child and C/2 to right child 
 * Write a function which takes input parameter as amount of liquid poured at top (L) and height of particular cup (h) index of that cup (i) and it should return amount of liquid absorbed in that cup.
 * Simply simulating the overflow behavior and do the calculation, O(level^2) solution
 */
public class CupTower {
	private static final int CAPACITY = 1;
	private int HIGH = 0;
	public double liquidPoured(double amount, int level, int index) {
		HIGH = level + 1;
		double[][] cups = new double[HIGH][HIGH];
		pour(cups, amount, 0, 0);
		return cups[level][index];
	}
	
	private void pour(double[][] cups, double amount, int level, int index) {
		if(level < HIGH) {
			cups[level][index] += amount;
			if(cups[level][index] > CAPACITY) {
				double halfAmount = (cups[level][index] - CAPACITY) / 2.0;
				cups[level][index] = CAPACITY;
				pour(cups, halfAmount, level + 1, index);
				pour(cups, halfAmount, level + 1, index + 1);
			}
		}
	}
}
