package com.niyue.coding.misc.meetingscheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.niyue.coding.careercup.disjointinterval.DisjointInterval.Interval;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32112869.html
 * Given a list of time intervals (meeting start time/end time) for meetings, 
 * only one meeting room is available,
 * how can you schedule the meetings so that maximum number of meetings can be held? 
 */

public class MeetingScheduler {
	private Integer[][] maxes;
	public List<Interval> schedule(List<Interval> meetings) {
		meetings = new ArrayList<Interval>(meetings);
		meetings.add(new Interval(-1, -1));
		Collections.sort(meetings);
		maxes = new Integer[meetings.size()][meetings.size()];
		maxScheduling(meetings, 1, 0);
		List<Interval> schedule = schedule(maxes, meetings);
		return schedule;
	}
	
	private int maxScheduling(List<Interval> meetings, int start, int lastMeeting) {
		int max = 0;
		if(start < meetings.size()) {
			if(maxes[start][lastMeeting] != null) {
				max = maxes[start][lastMeeting];
			} else {
				Interval current = meetings.get(start);
				Interval last = meetings.get(lastMeeting);
				int maxWithoutCurrent = maxScheduling(meetings, start + 1, lastMeeting);
				int maxWithCurrent = 0;
				if(current.start >= last.end) {
					maxWithCurrent = 1 + maxScheduling(meetings, start + 1, start);
				}
				max = Math.max(maxWithoutCurrent, maxWithCurrent);
				maxes[start][lastMeeting] = max;
			}
		}
		return max;
	}
	
	private List<Interval> schedule(Integer[][] maxes, List<Interval> meetings) {
		List<Interval> intervals = new ArrayList<Interval>();
		int last = 0;
		for(int i = 1; i < maxes.length; i++) {
			int maxWithCurrent = 1 + (i == maxes.length - 1 ? 0 : maxes[i + 1][i]);
			int maxWithoutCurrent = (i == maxes.length - 1 ? 0 : maxes[i + 1][last]);
			
			if(maxWithCurrent >= maxWithoutCurrent) {
				intervals.add(meetings.get(i));
				last = i;
			}
		}
		return intervals;
	}
}
