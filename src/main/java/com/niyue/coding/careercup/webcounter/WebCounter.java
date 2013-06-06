package com.niyue.coding.careercup.webcounter;

// Design a web counter to give how many hits per second, per minute
// i.e., what kind of data structure and algorithm would you use to do this?
// http://www.careercup.com/question?id=14908664
public class WebCounter {
	private int[] counts = new int[60*60];
	private int current = 0;
	
	public void hits(int hits) {
		int next = mod(current + 1);
		counts[next] = counts[current] + hits;
		current = next;
	}
	
	public int hitsInLastSecond() {
		return lastSeconds(1);
	}
	
	public int hitsInLastMinute() {
		return lastSeconds(60);
	}
	
	private int lastSeconds(int seconds) {
		return hitsInRange(mod(current - seconds), current);
	}
	
	// for modulo, Java gives the sign of the result equals the sign of the dividend
	private int mod(int position) {
		position = position % counts.length;
		if(position < 0) {
			position += counts.length;
		}
		return position;
	}
	
	private int hitsInRange(int start, int end) {
		return counts[end] - counts[start];
	}
}
