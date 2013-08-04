package com.niyue.coding.misc.cokemachine;

/*
 * http://www.careercup.com/question?id=15299689
 * http://www.mitbbs.com/article_t/JobHunting/32498481.html
 * Three coke machines. 
 * Each one has two values min & max, which means if you get coke from this machine it will load you a random volume in the range [min, max]. 
 * Given a cup size n and minimum soda volume m, 
 * show if it's possible to make it from these machines.
 * brute force solution
 */
public class CokeMachine {
	/*
	 * cokeMachines should have length 3 * 2 (three coke machines) according to the problem description
	 * but the algorithm here can be used to solve X coke machines problem
	 */
	public boolean fillable(int m, int n, int...cokeMachines) {
		assert cokeMachines.length % 2 == 0;
		assert n >= m;
		boolean fillable = false;
		if(n >= 0 && m <= 0) {
			fillable = true;
		} else if(n >= 0) {
			for(int i = 0; i < cokeMachines.length / 2; i++) {
				fillable = true;
				int low = cokeMachines[i * 2];
				int high = cokeMachines[i * 2 + 1];
				for(int vol = low; vol <= high; vol++) {
					fillable = fillable(m - vol, n - vol, cokeMachines);
					if(!fillable) {
						fillable = false;
						break;
					}
				}
				if(fillable) {
					break;
				}
			}
		}
		return fillable;
	}
}
