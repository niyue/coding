package com.niyue.coding.careercup.distributedmedian;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SlaveMachine implements Runnable {
	private final List<Integer> numbers;
	private final CyclicBarrier barrier;
	private ComparingCount count;
	private volatile double median;
	private Thread runningThread;
	
	public SlaveMachine(List<Integer> numbers, CyclicBarrier barrier) {
		this.numbers = numbers;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		System.out.format("[%s] Start running...\n", Thread.currentThread().getName());
		runningThread = Thread.currentThread();
		while(!Thread.currentThread().isInterrupted()) {
			System.out.format("[%s] counting for median %s\n", Thread.currentThread().getName(), median);
			count = calculateCount(numbers, median);
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	private ComparingCount calculateCount(List<Integer> numbers, double median) {
		int equal = 0;
		int less = 0;
		int greater = 0;
		Integer nearestSmall = null;
		Integer nearestBig = null;
		for(int n : numbers) {
			if(n == median) {
				equal++;
			} else if(n < median) {
				less++;
				if(nearestSmall == null || n > nearestSmall) {
					nearestSmall = n;
				}
			} else {
				greater++;
				if(nearestBig == null || n < nearestBig) {
					nearestBig = n;
				}
			}
		}
		ComparingCount count = new ComparingCount(less, equal, greater, nearestSmall, nearestBig);
		System.out.format("[%s] count for median %s is %s\n", Thread.currentThread().getName(), median, count);
		return count;
	}
	
	public ComparingCount getCount() {
		return count;
	}
	
	public void setMedian(double median) {
		this.median = median;
	}
	
	public void quit() {
		runningThread.interrupt();
	}
}
