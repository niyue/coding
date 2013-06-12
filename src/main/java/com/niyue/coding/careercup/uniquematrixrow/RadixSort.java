package com.niyue.coding.careercup.uniquematrixrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSort {
	private final static int RADIX = 2;
	public List<Row> sort(Row[] rows) {
		List<Queue<Row>> queues = new ArrayList<Queue<Row>>();
		for(int i = 0; i < RADIX; i++) {
			queues.add(new LinkedList<Row>());
		}
		int length = rows[0].values.length;
		List<Row> sortedRows = new ArrayList<Row>(Arrays.asList(rows));
		for(int i = 0; i < length; i++) {
			for(Row r : sortedRows) {
				queues.get(r.values[length - 1 - i]).offer(r);
			}
			sortedRows = new ArrayList<Row>();
			for(int b = 0; b < RADIX; b++) {
				sortedRows.addAll(queues.get(b));
				queues.get(b).clear();
			}
		}
		return sortedRows;
	}
}
