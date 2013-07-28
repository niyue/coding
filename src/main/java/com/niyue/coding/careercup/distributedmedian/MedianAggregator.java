package com.niyue.coding.careercup.distributedmedian;

import java.util.ArrayList;
import java.util.List;

public class MedianAggregator implements Runnable {
	private int min;
	private int max;
	private final int total;
	private DistributedMedian master;
	
	public MedianAggregator(DistributedMedian master, int min, int max, int total) {
		this.min = min;
		this.max = max;
		this.total = total;
		this.master = master;
	}
	
	private List<SlaveMachine> slaves = new ArrayList<SlaveMachine>();
	
	@Override
	public void run() {
		System.out.format("[MedianAggregator] Thread %s, doing aggreation, median is %s\n", Thread.currentThread().getName(), master.getMedian());
		int less = 0;
		int equal = 0;
		int greater = 0;
		Integer nearestSmall = null;
		Integer nearestBig = null;
		for(SlaveMachine slave : slaves) {
			ComparingCount count = slave.getCount();
			less += count.less;
			equal += count.equal;
			greater += count.greater;
			if(nearestSmall == null || count.nearestSmall != null && count.nearestSmall > nearestSmall) {
				nearestSmall = count.nearestSmall;
			}
			
			if(nearestBig == null || count.nearestBig != null && count.nearestBig < nearestBig) {
				nearestBig = count.nearestBig;
			}
		}
		
		boolean medianNotFound = Math.abs(less - greater) > equal;
		double median = master.getMedian();
		
		if(medianNotFound) {
			if(less > greater) {
				max = nearestSmall;
			} else {
				min = nearestBig;
			}
			median = min + (max - min) / 2.0;
			for(SlaveMachine slave : slaves) {
				slave.setMedian(median);
			}
		} else {
			if(total % 2 == 0) {
				if(equal == 0) {
					median = nearestSmall + (nearestBig - nearestSmall) / 2.0;
				} else {
					if(less + equal == greater) {
						median = median + (nearestBig - median) / 2.0;
					} else if(greater + equal == less) {
						median = nearestSmall + (median - nearestSmall) / 2.0;
					} 
				}
			}
			System.out.println("[MedianAggregator] Quit all slaves");
			for(SlaveMachine slave : slaves) {
				slave.quit();
			}
		}
		
		master.updateAggregation(median, medianNotFound);
		System.out.format("[MedianAggregator] median %s found, median is updated to %s\n", medianNotFound ? "not" : "",  median);
		synchronized (master) {
			System.out.println("[MedianAggregator] Notifying master");
			master.notify();
		}
	}
	
	public void add(SlaveMachine slave) {
		slaves.add(slave);
	}
}
