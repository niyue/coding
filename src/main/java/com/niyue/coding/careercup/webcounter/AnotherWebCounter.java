package com.niyue.coding.careercup.webcounter;

import java.util.ArrayList;
import java.util.List;

/*
 * http://www.careercup.com/question?id=6005446611566592
 * Use a resizable array list to keep the number of hits
 * Each hit contains the timestamp (round to a second) and the number of hits in this second
 * There are several pointers pointing to lastTwoSeconds/lastMinute/lastHour
 * And there is a timestamp keeping the latest time
 * When increament is called, if current time is the 
 */
public class AnotherWebCounter {
	private static final int SECONDS_IN_AN_HOUR = 60 * 60;
	private static final int NANOTH = 1_000_000_000;
	private List<Hit> hits = new ArrayList<Hit>(SECONDS_IN_AN_HOUR);
	private int twoSeconds = 0;
	private int minute = 0;
	private int hour = 0;
	private long latestTime;
	
	public AnotherWebCounter() {
		hits.add(new Hit(now(), 0));
	}
	
	public synchronized void increament() {
		long now = now();
		Hit lastHit = lastHit();
		if(latestTime == now) {
			lastHit.hit();
			System.out.println("last hits " + lastHit().count);
		} else {
			hits.add(new Hit(now, 1));
			latestTime = now;
			update(now);
			resize();
		}
	}
	
	private Hit lastHit() {
		return hits.get(hits.size() - 1);
	}
	
	private long now() {
		return System.nanoTime() / NANOTH;
	}
	
	private void resize() {
		if(hits.size() > 2 * SECONDS_IN_AN_HOUR) {
			hits = hits.subList(hits.size() - SECONDS_IN_AN_HOUR + 1, hits.size());
			minute -= SECONDS_IN_AN_HOUR;
			hour -= SECONDS_IN_AN_HOUR;
		}
	}
	
	private void update(long now) {
		moveTwoSeconds(now);
		moveMinute(now);
		moveHour(now);
	}
	
	private int movePointer(int hourOrMinute, int range, long now) {
		while(hourOrMinute < hits.size() - 1 && now - hits.get(hourOrMinute).time >= 60) {
			hourOrMinute++;
		}
		return hourOrMinute;
	}
	
	private void moveTwoSeconds(long now) {
		twoSeconds = movePointer(twoSeconds, 2, now);
	}
	
	private void moveMinute(long now) {
		minute = movePointer(minute, 60, now);
	}
	
	private void moveHour(long now) {
		hour = movePointer(hour, 3600, now);
	}
	
	public synchronized long hitsInLastTwoSeconds() {
		return hitsInRange(twoSeconds);
	}
	
	public synchronized long hitsInLastMinute() {
		return hitsInRange(minute);
	}
	
	public synchronized long hitsInLastHour() {
		return hitsInRange(hour);
	}
	
	private long hitsInRange(int minuteOrHour) {
		long now = System.nanoTime() / NANOTH;
		update(now);
		return lastHit().count - hits.get(minuteOrHour).count;
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
