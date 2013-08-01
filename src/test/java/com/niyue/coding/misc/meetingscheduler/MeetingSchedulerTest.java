package com.niyue.coding.misc.meetingscheduler;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.niyue.coding.careercup.disjointinterval.DisjointInterval.Interval;

public class MeetingSchedulerTest {

	@Test
	public void testOneMeeting() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 1)
		));
		assertThat(meetings.size(), is(1));
		assertThat(meetings.get(0), is(new Interval(0, 1)));
	}
	
	@Test
	public void testTwoDisjointMeetings() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 1),
				new Interval(2, 3)
		));
		assertThat(meetings.size(), is(2));
		assertThat(meetings.get(0), is(new Interval(0, 1)));
	}
	
	@Test
	public void testTwoJointMeetings() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 2),
				new Interval(1, 3)
		));
		assertThat(meetings.size(), is(1));
		assertThat(meetings.get(0), is(new Interval(0, 2)));
	}
	
	@Test
	public void testTwoJointMeetingsWithOneDisjointMeeting() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 2),
				new Interval(1, 3),
				new Interval(5, 9)
		));
		assertThat(meetings.size(), is(2));
		assertThat(meetings.get(0), is(new Interval(0, 2)));
		assertThat(meetings.get(1), is(new Interval(5, 9)));
	}
	
	@Test
	public void testTwoJointMeetingsWithOtherTwoJointMeeting() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 2),
				new Interval(1, 3),
				new Interval(5, 9),
				new Interval(7, 10)
		));
		assertThat(meetings.size(), is(2));
		assertThat(meetings.get(0), is(new Interval(0, 2)));
		assertThat(meetings.get(1), is(new Interval(5, 9)));
	}
	
	@Test
	public void testTwoNestedMeetingsWithOneDisjointMeeting() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 4),
				new Interval(1, 3),
				new Interval(5, 9)
		));
		assertThat(meetings.size(), is(2));
		assertThat(meetings.get(0), is(new Interval(0, 4)));
		assertThat(meetings.get(1), is(new Interval(5, 9)));
	}
	
	@Test
	public void testAVeryLongMeeting() {
		MeetingScheduler scheduler = new MeetingScheduler();
		List<Interval> meetings = scheduler.schedule(Arrays.asList(
				new Interval(0, 2),
				new Interval(1, 3),
				new Interval(1, 12),
				new Interval(5, 9),
				new Interval(7, 10)
		));
		assertThat(meetings.size(), is(2));
		assertThat(meetings.get(0), is(new Interval(0, 2)));
		assertThat(meetings.get(1), is(new Interval(5, 9)));
	}
}
