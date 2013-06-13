package com.niyue.coding.careercup.uniquematrixrow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RadixSort {
	private final static int RADIX = 2;
	public Row[] sort(Row[] rows) {
		List<Queue<Row>> queues = new ArrayList<Queue<Row>>();
		for(int i = 0; i < RADIX; i++) {
			queues.add(new ArrayDeque<Row>());
		}
		int length = rows[0].values.length;
		for(int i = 0; i < length; i++) {
			for(Row r : rows) {
				queues.get(r.values[length - 1 - i]).offer(r);
			}
			int count = 0;
			for(int b = 0; b < RADIX; b++) {
				for(int qi = 0; qi < queues.get(b).size(); qi++) {
					rows[count] = queues.get(b).poll();
					count++;
				}
			}
		}
		return rows;
	}
}
