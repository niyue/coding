package com.niyue.coding.careercup.webcounter;

import java.util.ArrayList;
import java.util.List;

public class AnotherWebCounter {
	private static final int SECONDS_IN_A_DAY = 60 * 60 * 24;
	private List<Hit> hits = new ArrayList<Hit>(SECONDS_IN_A_DAY);
	private int fiveSeconds = 0;
	private int minute = 0;
	private int hour = 0;
	private int last = 0;
	private long latestTime;
	
	public AnotherWebCounter() {
		latestTime = System.nanoTime();
		hits.add(new Hit(latestTime, 0));
	}
	
	public synchronized void increament() {
		long now = System.nanoTime();
		if(latestTime == now) {
			hits.get(last).hit();
		} else {
			hits.add(new Hit(now, 1));
			latestTime = now;
			last++;
			update(now);
			resize();
		}
	}
	
	private void resize() {
		if(hits.size() > 2 * SECONDS_IN_A_DAY) {
			hits = hits.subList(hits.size() - SECONDS_IN_A_DAY + 1, hits.size());
		}
	}
	
	private void update(long now) {
		moveFiveSeconds(now);
		moveMinute(now);
		moveHour(now);
	}
	
	private int movePointer(int hourOrMinute, int range, long now) {
		while(hourOrMinute < hits.size() - 1 && now - hits.get(hourOrMinute).time >= 60) {
			hourOrMinute++;
		}
		return hourOrMinute;
	}
	
	private void moveFiveSeconds(long now) {
		fiveSeconds = movePointer(fiveSeconds, 5, now);
	}
	
	private void moveMinute(long now) {
		minute = movePointer(minute, 60, now);
	}
	
	private void moveHour(long now) {
		hour = movePointer(hour, 3600, now);
	}
	
	public synchronized long hitsInLastFiveSeconds() {
		return hitsInRange(fiveSeconds);
	}
	
	public synchronized long hitsInLastMinute() {
		return hitsInRange(minute);
	}
	
	public synchronized long hitsInLastHour() {
		return hitsInRange(hour);
	}
	
	private long hitsInRange(int minuteOrHour) {
		long now = System.nanoTime();
		update(now);
		return hits.get(last).count - hits.get(minuteOrHour).count;
	}
	
	private static class Hit {
		public final long time;
		private long count = 0;
		public Hit(long now, long count) {
			this.time = now;
			this.count = count;
		}
		
		private void hit() {
			this.count++;
		}
	}
}
