package com.niyue.coding.careercup.reservoirsampling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// http://www.careercup.com/question?id=14922622
public class ReservoirSampling {
	public List<Integer> sample(Iterator<Integer> numbers, int sampleSize) {
		List<Integer> samples = new ArrayList<Integer>(sampleSize);
		int count = 0;
		Random random = new Random();
		while(numbers.hasNext()) {
			count++;
			int number = numbers.next();
			if(samples.size() < sampleSize) {
				samples.add(number);
			} else {
				int ran = random.nextInt(count);
				if(ran < sampleSize) {
					samples.set(ran, number);
				}
			}
		}
		return samples;
	}
}
