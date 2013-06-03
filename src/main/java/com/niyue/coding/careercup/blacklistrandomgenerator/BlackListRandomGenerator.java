package com.niyue.coding.careercup.blacklistrandomgenerator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

// http://www.careercup.com/question?id=15071816
// Give a min and max of an integer array
// write a function to randomly return a number inside of this range, but not in the list. 
public class BlackListRandomGenerator {
	public int generate(int n, List<Integer> blackList) {
		Collections.sort(blackList);
		int size = n - blackList.size();
		Random random = new Random();
		int ran = random.nextInt(size) + 1;
		for(int blackListNumber : blackList) {
			if(ran >= blackListNumber) {
				ran++;
			} else {
				break;
			}
		}
		return ran;
	}
}
