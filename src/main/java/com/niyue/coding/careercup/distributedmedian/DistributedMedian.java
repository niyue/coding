package com.niyue.coding.careercup.distributedmedian;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/*
 * http://www.careercup.com/question?id=6116886
 * http://www.quora.com/Distributed-Algorithms/What-is-the-distributed-algorithm-to-determine-the-median-of-arrays-of-integers-located-on-different-computers
 * http://discuss.joelonsoftware.com/default.asp?interview.11.444752.8
 * https://github.com/afshin/distributed-median
 * Given P machines, each containing an array of N elements, 
 * find the medium of the array resulted by concatenating all the arrays on the machines. 
 * Simulate multiple slave machines with multiple threads and using CyclicBarrier for thread synchronization
 * 
 * This class implements the distributed binary search method, which requires O(lg(max-min)) * NP
 * Given an estimated median, each slave machine counts how many numbers are less/equal/greater than the estimated median, and the nearest small/big number in this machine for the estimated median
 * In master machine, all countings will be aggregated.
 * A median is found when Math.abs(less - greater) <= equal 
 * 		If the total is odd, median is the equal value
 * 		If the total is even, median is the average in one of four cases: 1) nearest small + nearest big 2)  equal + nearest small 3) equal + nearest big 4) equal
 * If median is not found, the next estimated median will be one of two cases: 1) (min + nearest small) / 2.0 2) (nearest big + max) / 2.0
 *   
 * FIXME: there is a synchronization bug with the code
 * BrokenBarrierException => some slave awaiting while getting resetting
 * root cause: aggregator notifies master => master wakes up immediately (aggregator is still running, having the barrier in last generation) => master resets barrier
 * This can be solved more easily by NOT reusing the CyclicBarrier but re-creating a new barrier but this makes the simulation less meaningful
 */
public class DistributedMedian {
	private volatile double median = 0;
	private volatile boolean medianNotFound = true; 
	
	public double find(List<List<Integer>> numbers) {
		int min = findMin(numbers);
		int max = findMax(numbers);
		int total = total(numbers);
		
		updateAggregation(min + (max - min) / 2.0, true);
		
		MedianAggregator aggregator = new MedianAggregator(this, min, max, total);
		CyclicBarrier barrier = new CyclicBarrier(numbers.size(), aggregator);
		List<Thread> slaves = new ArrayList<Thread>(numbers.size());
		for(int i = 0; i < numbers.size(); i++) {
			SlaveMachine slaveMachine = new SlaveMachine(numbers.get(i), barrier);
			aggregator.add(slaveMachine);
			slaveMachine.setMedian(median);
			Thread slave = new Thread(slaveMachine, String.format("Slave-%s", i));
			slaves.add(slave);
			slave.start();
		}
		
		while(true) {
			try {
				if(medianNotFound) {
					synchronized (this) {
						if(medianNotFound) {
							System.out.println("[Master] Waiting for the aggregator");
							wait();
							System.out.println("[Master] Got notification from the aggregator");
						} else {
							System.out.format("[Master] median is %s\n", median);
							break;
						}
					}
					if(medianNotFound) {
						System.out.format("[Master] Resetting barrier\n");
						barrier.reset();
					}
				} else {
					System.out.format("[Master] median is %s\n", median);
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return median;
	}
	
	public void updateAggregation(double median, boolean medianNotFound) {
		this.median = median;
		this.medianNotFound = medianNotFound;
	}
	
	public double getMedian() {
		return median;
	}
	
	private int total(List<List<Integer>> numbers) {
		int total = 0;
		for(List<Integer> nums : numbers) {
			total += nums.size();
		}
		return total;
	}
	
	private int findMin(List<List<Integer>> numbers) {
		int min = Integer.MAX_VALUE;
		for(List<Integer> nums : numbers) {
			MinMax mm = findMinMax(nums);
			if(mm.min < min) {
				min = mm.min;
			}
		}
		return min;
	}
	
	private int findMax(List<List<Integer>> numbers) {
		int max = Integer.MIN_VALUE;
		for(List<Integer> nums : numbers) {
			MinMax mm = findMinMax(nums);
			if(mm.max > max) {
				max = mm.max;
			}
		}
		return max;
	}
	// FIXME: this should be done in the slave machine instead of master machine
	private MinMax findMinMax(List<Integer> numbers) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int n : numbers) {
			if(n < min) {
				min = n;
			}
			if(n > max) {
				max = n;
			}
		}
		return new MinMax(min, max);
	}
}
